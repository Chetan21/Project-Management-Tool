/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package controllerpackage;


import GUIpackage.UserGUI;
import modelpackage.CommunicationsTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.event.*;

/**
 *
 * @author erwin
 
public class CommunicationsController implements ListSelectionListener, TableModelListener{
    
    private CommunicationsTableModel commTableModel;
    private UserGUI gui;
    
    public CommunicationsController(UserGUI gui)
    {
        this.gui = gui;
        //commTableModel = new CommunicationsTableModel();
        commTableModel = new CommunicationsTableModel(gui.getProjectID());
        commTableModel.addTableModelListener(this);
    }
    
    public TableModel getTableModel()
    {
        return commTableModel;
    }
    
    public void valueChanged (ListSelectionEvent e) 
    {
        ListSelectionModel selectModel = (ListSelectionModel) e.getSource();
        int firstIndex = selectModel.getMinSelectionIndex();
        
        try 
        {
            if (firstIndex >= 0)
            {
                commTableModel.setSelectedRow(firstIndex);
                gui.setNotesTextArea((String)commTableModel.getValueAt(firstIndex, 2));
                gui.setTimestampDateChooser((String)commTableModel.getValueAt(firstIndex, 1));
                gui.setEnteredByComboBox((String)commTableModel.getValueAt(firstIndex, 3));
                gui.setContactNameTextField((String)commTableModel.getValueAt(firstIndex, 4));
            }
        } catch(Exception err) {
            err.toString();
	}
    }
    
    public void tableChanged(TableModelEvent e)
    {
	try
        {
            int firstIndex = e.getFirstRow();
            commTableModel = new CommunicationsTableModel(commTableModel.getList(), commTableModel.getEntityManager());
            commTableModel.addTableModelListener(this);
            gui.updateCommTable();
            gui.setNotesTextArea((String)commTableModel.getValueAt(firstIndex, 2));
            gui.setTimestampDateChooser((String)commTableModel.getValueAt(firstIndex, 1));
            gui.setEnteredByComboBox((String)commTableModel.getValueAt(firstIndex, 3));
            gui.setContactNameTextField((String)commTableModel.getValueAt(firstIndex, 4));
	} 
        catch (Exception exp)
        {
            exp.getMessage();
            exp.printStackTrace();
	}
    }
    
    public void addCommunicationRow(Object[] array)
    {
	commTableModel.addCommunicationRow(array);
    }
    
}
*/
