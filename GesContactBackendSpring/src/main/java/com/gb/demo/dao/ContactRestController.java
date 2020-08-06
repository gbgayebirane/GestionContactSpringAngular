package com.gb.demo.dao;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.hibernate.query.QueryParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gb.demo.entities.Contact;

@RestController
@CrossOrigin("*")
public class ContactRestController 
{
	    @Autowired
		private ContactRepository cr;
	    
	    @RequestMapping(value="/Contacts",method=RequestMethod.GET)
	    public List<Contact> getContacts()
	    {
	    	return cr.findAll();
	    }
	    @RequestMapping(value="/Contacts/{id}",method=RequestMethod.GET)
	    public Optional<Contact> getone(@PathVariable Long id)
	    {
	    	return cr.findById(id);
	    }
	    @RequestMapping(value="/Contacts",method=RequestMethod.POST)
	    public Contact save(@RequestBody Contact c)
	    {
	    	return cr.save(c);
	    }
	    @RequestMapping(value="/Contacts/{id}",method=RequestMethod.DELETE)
	    public boolean supprimer(@PathVariable Long id)
	    {
	    	cr.deleteById(id);
	    	return  true;
	    }
	    @RequestMapping(value="/Contacts",method=RequestMethod.PUT)
	    public Contact update(Long id,@RequestBody Contact c)
	    {
	    	c.setId(id);
	    	return cr.save(c);
	    }
	    @RequestMapping(value="/chercherContacts",method=RequestMethod.GET)
	    public Page<Contact> chercher(
	    @RequestParam(name="mc",defaultValue="") String mc,
	    @RequestParam(name="page",defaultValue="1") int page,
	    @RequestParam(name="size",defaultValue="1") int size)
	    {
	    	return cr.chercher("%"+mc+"%",PageRequest.of(page, size));

	    }
	    
	    @RequestMapping(value="/chercherContact",method=RequestMethod.GET)
	    public List<Contact> cherchersanspagination(
	    @RequestParam(name="mc",defaultValue="") String mc)
	    {
	    	return cr.cherchersans("%"+mc+"%");

	    }
}
