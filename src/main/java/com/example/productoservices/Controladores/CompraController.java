package com.example.productoservices.Controladores;

import com.example.productoservices.Controladores.DAO.LoginResponse;
import com.example.productoservices.Controladores.DAO.RegistroResponseDao;
import com.sendgrid.*;
import com.example.productoservices.Controladores.DAO.PlanesDao;
import com.example.productoservices.Controladores.DAO.VentaDao;
import com.example.productoservices.Dao.ProductoDao;
import com.example.productoservices.Entidades.Planes;
import com.example.productoservices.Entidades.Venta;
import com.example.productoservices.Repositorio.PlanRepositorio;
import com.example.productoservices.Repositorio.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CompraController {

    @Autowired
    PlanRepositorio planRepositorio;
    @Autowired
    VentaRepositorio ventaRepositorio;
    @Autowired
    RestTemplate restTemplate;

    @PostMapping("/venta")
    public VentaDao agregandoCompra (@RequestBody VentaDao ventaDao) throws Exception{
        Planes planes = planRepositorio.findById(ventaDao.planes).get();
        Venta venta = new Venta();
        venta.setFecha_venta(new Date());
        venta.setPlanes(planes);
        venta.setMonto(ventaDao.monto);
        venta.setUsuario(ventaDao.usuario);

        Venta venta1 = ventaRepositorio.save(venta);
        VentaDao ventaDao1 = new VentaDao();

        ventaDao1.monto = venta1.getMonto();
        ventaDao1.planes = planes.getNombre();
        ventaDao1.usuario = venta1.getUsuario();
        enviandoCompraCliente(ventaDao1);
//        enviandoEmail(ventaDao1);

        return ventaDao1;
    }

    //Prueba Sendrgip
    @GetMapping("/mail")
    public void SendMail() throws IOException{

            Email from = new Email("jeanmelvinlp27@gmail.com");
            String subject = "Sending with SendGrid is Fun WAWAWAWAWAWA";
            Email to = new Email("jmlpwebmaster@gmail.com");
            Content content = new Content("text/plain", "and easy to do anywhere, even with Java");
            Mail mail = new Mail(from, subject, to, content);

            SendGrid sg = new SendGrid("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");
            Request request = new Request();
            try {
                request.setMethod(Method.POST);
                request.setEndpoint("mail/send");
                request.setBody(mail.build());
                Response response = sg.api(request);
                System.out.println(response.getStatusCode());
                System.out.println(response.getBody());
                System.out.println(response.getHeaders());
            } catch (IOException ex) {
                throw ex;
            }
    }

    @CrossOrigin(origins = "http://localhost:8009")
    @GetMapping("/venta")
    public ArrayList<PlanesDao> productos() {
        List<Planes> planes = planRepositorio.findAll();
        ArrayList<PlanesDao> planesDaos = new ArrayList<>();
        for(Planes p: planes) {
            PlanesDao pDao = new PlanesDao();
            pDao.costo = p.getCosto();
            pDao.nombre = p.getNombre();
            planesDaos.add(pDao);
        }
        return planesDaos;
    }
    public LoginResponse[] getEmpleados() {
        return restTemplate.getForObject("http://servicio-usuarios/api/auth/empleados", LoginResponse[].class);
    }
    public LoginResponse[] getClientes() {
        return restTemplate.getForObject("http://servicio-usuarios/api/auth/clientes", LoginResponse[].class);
    }
    public void enviandoEmail(VentaDao ventaDAO) throws IOException {
        Email from = new Email("deparmento@fotosjr.com");
        String subject = "Compra completada";
        LoginResponse []responses = restTemplate.getForObject("http://servicio-usuarios/api/auth/empleados", LoginResponse[].class);

        assert responses != null;
        System.out.println(responses.length);
        for (LoginResponse lr: responses) {
            System.out.println(lr.email);
            Email to = new Email(lr.email);
            Content content = new Content("text/plain", "Tiene un nuevo trabajo para el Usuario: " + ventaDAO.usuario + ", del paquete " + ventaDAO.planes);
            Mail mail = new Mail(from, subject, to, content);
            SendGrid sg = new SendGrid(/*"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"*/"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");
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        }
    }
    public void enviandoCompraCliente(VentaDao ventaDAO) throws IOException {
        Email from = new Email("deparmento@fotosjr.com");
        String subject = "Compra completada";
        LoginResponse []responses = restTemplate.getForObject("http://servicio-usuarios/api/auth/clientes", LoginResponse[].class);

        assert responses == null;
        System.out.println(responses.length);
        for (LoginResponse lr: responses) {
            System.out.println(lr.email);
            Email to = new Email(lr.email);
            Content content = new Content("text/plain", "Su Compra ha sido completada: " + ventaDAO.usuario + ", del paquete " + ventaDAO.planes);
            Mail mail = new Mail(from, subject, to, content);
            SendGrid sg = new SendGrid("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");
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sg.api(request);
            System.out.println(response.getStatusCode());
            System.out.println(response.getBody());
            System.out.println(response.getHeaders());
        }
    }

}
