package com.autentia.tutoriales.ctrl;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.autentia.tutoriales.entity.Footballer;

@ManagedBean
@ViewScoped
public class TreeCtrl implements Serializable {

	private static final long serialVersionUID = 7412913131003085264L;

	private TreeNode sourceRoot;

	private TreeNode targetRoot;

	@SuppressWarnings("unused")
	@PostConstruct
	private void init() {
		sourceRoot = new DefaultTreeNode("Root 1", null);
		targetRoot = new DefaultTreeNode("Root 2", null);

		TreeNode node0 = new DefaultTreeNode("Node 0", sourceRoot);
		TreeNode node1 = new DefaultTreeNode("Node 1", sourceRoot);
	}

	public void addItemToTargetRoot(DragDropEvent ddEvent) {
		Footballer footballer = ((Footballer)ddEvent.getSource());

		System.out.println(footballer.getName());

		// targetRoot.add(car);
		// carsSmall.remove(car);
	}

	public TreeNode getSourceRoot() {
		return sourceRoot;
	}

	public TreeNode getTargetRoot() {
		return targetRoot;
	}
}