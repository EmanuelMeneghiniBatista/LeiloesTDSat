import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 * Tela de vendas: exibe somente os produtos com status "Vendido".
 */
public class vendasVIEW extends javax.swing.JFrame {

    public vendasVIEW() {
        initComponents();
        listarVendas();
    }

    private void initComponents() {
        setTitle("Vendas");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.JLabel titulo = new javax.swing.JLabel("Produtos Vendidos", javax.swing.SwingConstants.CENTER);
        titulo.setFont(new java.awt.Font("Lucida Fax", 0, 18));
        titulo.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 15, 10));

        listaVendas = new javax.swing.JTable();
        listaVendas.setModel(new DefaultTableModel(
            new Object[][]{},
            new String[]{"ID", "Nome", "Valor", "Status"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        javax.swing.JScrollPane scroll = new javax.swing.JScrollPane(listaVendas);

        javax.swing.JButton btnVoltar = new javax.swing.JButton("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dispose();
            }
        });
        javax.swing.JPanel rodape = new javax.swing.JPanel();
        rodape.add(btnVoltar);

        getContentPane().setLayout(new java.awt.BorderLayout());
        getContentPane().add(titulo, java.awt.BorderLayout.NORTH);
        getContentPane().add(scroll, java.awt.BorderLayout.CENTER);
        getContentPane().add(rodape, java.awt.BorderLayout.SOUTH);
        setSize(520, 400);
        setLocationRelativeTo(null);
    }

    private void listarVendas() {
        ProdutosDAO produtosdao = new ProdutosDAO();

        DefaultTableModel model = (DefaultTableModel) listaVendas.getModel();
        model.setNumRows(0);

        ArrayList<ProdutosDTO> vendidos = produtosdao.listarProdutosVendidos();

        for (int i = 0; i < vendidos.size(); i++) {
            model.addRow(new Object[]{
                vendidos.get(i).getId(),
                vendidos.get(i).getNome(),
                vendidos.get(i).getValor(),
                vendidos.get(i).getStatus()
            });
        }
    }

    private javax.swing.JTable listaVendas;
}
