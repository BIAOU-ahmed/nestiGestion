/**
 * 
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import component.OrderPanel;
import dao.OrderDAO;

/**
 * @author ahmed
 *
 */
public class OrderNumberListener implements ActionListener {
	OrderPanel panel;
	
	public OrderNumberListener(OrderPanel panel) {
		this.panel = panel;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (panel.getComboBoxProviderOrder().getSelectedItem().toString().isEmpty()) {
			if (panel.getComboBoxOrderNumberOrder().getSelectedItem() != null) {

				if (!panel.getComboBoxOrderNumberOrder().getSelectedItem().toString().isEmpty()) {
					var order = (new OrderDAO()).find("idOrders",
							panel.getComboBoxOrderNumberOrder().getSelectedItem().toString());
//					System.out.println("order number act");

					panel.getComboBoxProviderOrder().setSelectedItem(order.getProvider().getCompanyName());

				} else {

					panel.getComboBoxProviderOrder().setSelectedIndex(0);

				}

				panel.refreshArticle();
			}

		}
		panel.refreshTable();
		
	}

}
