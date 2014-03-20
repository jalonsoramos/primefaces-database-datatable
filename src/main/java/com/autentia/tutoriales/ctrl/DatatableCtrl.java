package com.autentia.tutoriales.ctrl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.LazyDataModel;

import com.autentia.tutoriales.dao.service.Dao;
import com.autentia.tutoriales.entity.Footballer;

@ManagedBean
@ViewScoped
public class DatatableCtrl implements Serializable {

	private static final long serialVersionUID = 4089937794197364974L;

	private LazyDataModel<Footballer> footballers;

	@ManagedProperty(value = "#{dao}")
	private Dao dao;

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		final Long numEvents = (Long) dao.findByQuery(
				"select count(id) from Footballer", -1, -1, null).get(0);

		footballers = new LazyDataModel<Footballer>(numEvents.intValue()) {

			private static final long serialVersionUID = 8885722005055879976L;

			@SuppressWarnings("unchecked")
			@Override
			public List<Footballer> fetchLazyData(int first, int pageSize) {
				return dao
						.findByQuery("from Footballer", first, pageSize, null);
			}
		};
	}

	public LazyDataModel<Footballer> getFootballers() {
		return footballers;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

}
