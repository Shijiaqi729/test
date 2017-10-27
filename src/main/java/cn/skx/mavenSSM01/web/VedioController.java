package cn.skx.mavenSSM01.web;

import cn.skx.mavenSSM01.model.Vedio;
import cn.skx.mavenSSM01.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class VedioController {
    @Autowired
    private VedioService vedioService;

    /**
     * 获取所有电影
     * */
    @RequestMapping(value = "vedios" , method = RequestMethod.GET)
    public ResponseEntity<List<Vedio>> getAllVedios(){
        List<Vedio> vedios = vedioService.getAllVedio();
        if (vedios.isEmpty()){
            return new ResponseEntity<List<Vedio>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Vedio>>(vedios,HttpStatus.OK);
    }

    /**
     * 根据id获取电影
     * */
    @RequestMapping(value = "vedios/{id}",method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vedio> getVedioById(@PathVariable("id") int id){
        Vedio vedio = vedioService.getVedioById(id);
        if (vedio == null){
            System.out.println("not found!");
            return new ResponseEntity<Vedio>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Vedio>(vedio,HttpStatus.OK);
    }

    /**
     * 创建电影
     * */
    @RequestMapping(value = "vedios",method = RequestMethod.POST)
    public ResponseEntity<Vedio> creatVedio(@RequestBody Vedio vedio, UriComponentsBuilder builder){
        vedioService.creatVedio(vedio);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/vedios/{id}").buildAndExpand(vedio.getId()).toUri());
        return  new ResponseEntity<Vedio>(headers,HttpStatus.CREATED);
    }

    /**
     * 更新电影
     * */
    @RequestMapping(value = "vedios/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Vedio> updateVedio(@PathVariable("id") int id ,@RequestBody Vedio vedio){
        Vedio currentVedio = vedioService.getVedioById(id);
        if (currentVedio == null){
            System.out.println("not found!");
            return new ResponseEntity<Vedio>(HttpStatus.NOT_FOUND);
        }
        currentVedio.setActor(vedio.getActor());
        currentVedio.setName(vedio.getName());
        currentVedio.setPic(vedio.getPic());

        vedioService.updateVedio(currentVedio);
        return new ResponseEntity<Vedio>(currentVedio,HttpStatus.OK);
    }

    /**
     * 删除电影
     * */
    @RequestMapping(value = "vedios/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Vedio> deleteVedio(@PathVariable("id") int id){
        Vedio vedio = vedioService.getVedioById(id);
        if (vedio == null){
            System.out.println("not found!");
            return  new ResponseEntity<Vedio>(HttpStatus.NOT_FOUND);
        }
        vedioService.deleteVedio(id);
        return new ResponseEntity<Vedio>(HttpStatus.NO_CONTENT);
    }

}
