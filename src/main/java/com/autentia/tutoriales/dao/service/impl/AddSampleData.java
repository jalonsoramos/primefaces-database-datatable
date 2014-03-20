package com.autentia.tutoriales.dao.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.autentia.tutoriales.dao.service.Dao;
import com.autentia.tutoriales.entity.Footballer;

@Service
public class AddSampleData extends HibernateDaoSupport {

	private Dao dao;

	@Autowired
	public AddSampleData(Dao dao, SessionFactory factory) {
		super.setSessionFactory(factory);
		this.dao = dao;
	}

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		final List<Footballer> list = new ArrayList<Footballer>();

		final Footballer iker = new Footballer();
		iker.setName("Iker");
		iker.setLastname("Casillas");
		iker.setNumber(1);
		list.add(iker);

		final Footballer pepe = new Footballer();
		pepe.setName("Pepe");
		pepe.setLastname("Lima");
		pepe.setNumber(3);
		list.add(pepe);

		final Footballer sergio = new Footballer();
		sergio.setName("Sergio");
		sergio.setLastname("Ramos");
		sergio.setNumber(4);
		list.add(sergio);

		final Footballer albiol = new Footballer();
		albiol.setName("Raúl");
		albiol.setLastname("Albiol");
		albiol.setNumber(18);
		list.add(albiol);

		final Footballer arbeloa = new Footballer();
		arbeloa.setName("Álvaro");
		arbeloa.setLastname("Arbeloa");
		arbeloa.setNumber(17);
		list.add(arbeloa);

		final Footballer carvalho = new Footballer();
		carvalho.setName("Ricardo");
		carvalho.setLastname("Carvalho");
		carvalho.setNumber(2);
		list.add(carvalho);

		final Footballer alonso = new Footballer();
		alonso.setName("Xabi");
		alonso.setLastname("Alonso");
		alonso.setNumber(14);
		list.add(alonso);

		final Footballer khedira = new Footballer();
		khedira.setName("Sami");
		khedira.setLastname("Khedira");
		khedira.setNumber(24);
		list.add(khedira);

		final Footballer kaka = new Footballer();
		kaka.setName("Kaka");
		kaka.setLastname("Dos Santos");
		kaka.setNumber(8);
		list.add(kaka);

		final Footballer granero = new Footballer();
		granero.setName("Esteban");
		granero.setLastname("Granero");
		granero.setNumber(11);
		list.add(granero);

		final Footballer leon = new Footballer();
		leon.setName("Pedro");
		leon.setLastname("León");
		leon.setNumber(21);
		list.add(leon);

		final Footballer canales = new Footballer();
		canales.setName("Sergio");
		canales.setLastname("Canales");
		canales.setNumber(16);
		list.add(canales);

		final Footballer ozil = new Footballer();
		ozil.setName("Mesut");
		ozil.setLastname("Ozil");
		ozil.setNumber(23);
		list.add(ozil);

		final Footballer diMaria = new Footballer();
		diMaria.setName("Angel");
		diMaria.setLastname("Di María");
		diMaria.setNumber(22);
		list.add(diMaria);

		final Footballer ronaldo = new Footballer();
		ronaldo.setName("Cristiano");
		ronaldo.setLastname("Ronaldo");
		ronaldo.setNumber(7);
		list.add(ronaldo);

		final Footballer benzema = new Footballer();
		benzema.setName("Karim");
		benzema.setLastname("Benzema");
		benzema.setNumber(9);
		list.add(benzema);

		final Footballer higuain = new Footballer();
		higuain.setName("Gonzalo");
		higuain.setLastname("Higuaín");
		higuain.setNumber(20);
		list.add(higuain);

		dao.saveOrUpdate(list);
	}
}
