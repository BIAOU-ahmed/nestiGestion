/**
 * 
 */
package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author ahmed
 *
 */
public class ProductListListener implements MouseListener{
	DefaultTableModel productModel;
	JTable productList;
	JTextField libeleTxt;
	JComboBox typeCombo;
	JComboBox unityCombo;
	public ProductListListener(DefaultTableModel productModel,JTable productList,JTextField libeleTxt,JComboBox typeCombo,JComboBox unityCombo) {
		this.productModel = productModel;
		this.productList = productList;
		this.libeleTxt = libeleTxt;
		this.typeCombo = typeCombo;
		this.unityCombo = unityCombo;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (!productList.getSelectionModel().isSelectionEmpty()) {
			int row = productList.getSelectedRow();
			libeleTxt.setText((String) productModel.getValueAt(row, 1));
			
//			String t = ((String) productModel.getValueAt(row, 1));
//			System.out.println(t);
//			if(((String) productModel.getValueAt(row, 2)).equals("Ingredient")) {
//				typeCombo.setSelectedItem("Ingredients");
//			}else {
//				typeCombo.setSelectedItem("Ustensils");
//			}
			
			typeCombo.setSelectedItem((String) productModel.getValueAt(row, 2));
			unityCombo.setSelectedItem((String) productModel.getValueAt(row, 3));
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
