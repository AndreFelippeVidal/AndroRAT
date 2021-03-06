package gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserModel extends AbstractTableModel {
	private final List<User> users = new ArrayList<User>();
	private final String[] headers = { "Flag", "IMEI", "Location", "Phone Number", "Operator", "Country SIM",
			"Operator SIM", "Serial SIM" };

	public UserModel() {
		super();
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return headers.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return headers[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex < users.size()) {
			switch (columnIndex) {
			case 0:
				return users.get(rowIndex).getImage();
			case 1:
				return users.get(rowIndex).getImei();
			case 2:
				return users.get(rowIndex).getCountryCode();
			case 3:
				return users.get(rowIndex).getTelNumber();
			case 4:
				return users.get(rowIndex).getOperator();
			case 5:
				return users.get(rowIndex).getSimCountryCode();
			case 6:
				return users.get(rowIndex).getSimOperator();
			case 7:
				return users.get(rowIndex).getSimSerial();
			default:
				return null;
			}
		} else
			return null;
	}

	public void addUser(User user) {
		users.add(user);
		fireTableRowsInserted(users.size() - 1, users.size() - 1);
	}

	public void removeUser(String imei) {
		for (User user : users) {
			if (user.getImei().equals(imei)) {
				users.remove(user);
				return;
			}
		}
	}
}
