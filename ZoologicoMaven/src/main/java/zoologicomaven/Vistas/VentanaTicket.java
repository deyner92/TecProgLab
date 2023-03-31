/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package zoologicomaven.Vistas;

import zoologicomaven.ZoologicoMaven;

import com.itextpdf.text.pdf.PdfPTable;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import zoologicomaven.Adicional;
import zoologicomaven.Plan;
import java.text.DecimalFormat;
/**
 *
 * @author Deyner Tenorio
 */
public class VentanaTicket extends javax.swing.JFrame {
   private Plan plan;
   private ArrayList<Plan> arrayPlan;
   private int idTicket;
   private Adicional adicional;
   private DecimalFormat df = new DecimalFormat("#,###.##");
    /**
     * Creates new form VentanaTicket
     */
    public VentanaTicket() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
        arrayPlan=new ArrayList<Plan>();
        AgregarVentas();
        idTicket=ExtraerMaxNumTicket()+1;
        lbId.setText(Integer.toHexString(idTicket));
    }

    
       public void AgregarVentas(){
        Plan plan1 = new Plan("Individual", 1, 0, 0, 10000,1);
        Plan plan2 = new Plan("Pareja", 2, 0, 5, 19000,2);
        Plan plan3 = new Plan("Familiar", 6, 2, 8, 64400,3);
        Plan plan4 = new Plan("Corporativo", 60, 23, 10, 643500,4);
        Plan plan5 = new Plan("Individual", 2, 0, 0, 20000,5);
        arrayPlan.add(plan1);
        arrayPlan.add(plan2);
        arrayPlan.add(plan3);
        arrayPlan.add(plan4);
        arrayPlan.add(plan5);
        
       } 
      public void onEndPage(PdfWriter writer, Document document) {
        
          ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Zoologico Naturalvida | Carrera 47 # 89-52 Barrio Aguacatala - Medellín | Tel: 320 000 1252"), 295, 30, 0);
        //ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("page " + document.getPageNumber()), 550, 30, 0);
    
      }
    
      public int ExtraerMaxNumTicket()
      {
          Plan elemento =new Plan();
          int i , max=0;
           for (i=0;i<arrayPlan.size();i++)
        {    
            elemento=arrayPlan.get(i);
            System.out.println(max<elemento.getId());
            if(max<elemento.getId()){
                max=elemento.getId();
                System.out.println(max);
            }
                
         
        }
           return max;
      }
      
      
      
    public String GenerarInforme() throws FileNotFoundException, DocumentException
    {
        
        Document documento = new Document();
        String txt = "Zoologico\n" + "Naturalvida\n" + "Conservando la naturaleza \nInforme de Ventas", ruta="D:/Info.pdf";
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        
        documento.open();
        
        Font fontTitulo = new Font(Font.FontFamily.HELVETICA,26,Font.BOLD);
        Font fontTablas = new Font(Font.FontFamily.HELVETICA,12,Font.BOLD);
        Paragraph titulo = new Paragraph (txt,fontTitulo);
        
        titulo.setAlignment(Element.ALIGN_RIGHT);
        //documento.add(titulo);
        
        PdfPTable tablaEncabezado = new PdfPTable(2);
        tablaEncabezado.setWidthPercentage(100);
        
        //Paragraph paragraph1 = new Paragraph ("");
        
        
        
        
            PdfPTable table = new PdfPTable(7); // Crea una tabla con 3 columnas
                table.setWidthPercentage(100); // La tabla ocupa el ancho completo de la página
                table.setSpacingBefore(10f); // Espacio antes de la tabla
                table.setSpacingAfter(10f); // Espacio después de la tabla

                // Agrega encabezados a la tabla
                PdfPCell cell0 = new PdfPCell(new Paragraph("Id venta",fontTablas));
                PdfPCell cell1 = new PdfPCell(new Paragraph("Tipo de Plan",fontTablas));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Cant. Adultos",fontTablas));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Cant. Ninos",fontTablas));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Valor ant. Desc.",fontTablas));
                PdfPCell cell5 = new PdfPCell(new Paragraph("descuento",fontTablas));
                PdfPCell cell6 = new PdfPCell(new Paragraph("valor Total",fontTablas));
                table.addCell(cell0);
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                
          Plan elemento;
          int i, cantNinos=0,cantAdultos=0;
          float ventas=0, totalVentas=0,desc; 
                  
         for (i=0;i<arrayPlan.size();i++)
        {    
            elemento=arrayPlan.get(i);
            float subValor;
            subValor=(elemento.getValor()/(1.0f-(elemento.getDescuento()/100.0f)));
            System.out.println(""+subValor);
            
            PdfPCell idCelda            =new PdfPCell(new Paragraph(Integer.toString(elemento.getId())));         
            PdfPCell tipoPlanCelda      =new PdfPCell(new Paragraph(elemento.getTipoPlan()));
            PdfPCell cantAdultosCelda   =new PdfPCell(new Paragraph(df.format(elemento.getCantAdultos())));
            PdfPCell cantNinosCelda     =new PdfPCell(new Paragraph(df.format(elemento.getCantNinos())));
            PdfPCell subValorCelda      =new PdfPCell(new Paragraph(df.format(subValor)));
            PdfPCell descuentoCelda     =new PdfPCell(new Paragraph((df.format(elemento.getDescuento())+"%")));
            PdfPCell valorCelda         =new PdfPCell(new Paragraph(df.format(elemento.getValor())));
            table.addCell(idCelda);
            table.addCell(tipoPlanCelda);
            table.addCell(cantAdultosCelda);
            table.addCell(cantNinosCelda);
            table.addCell(subValorCelda);
            table.addCell(descuentoCelda);
            table.addCell(valorCelda);
            
            ventas+=subValor;
            totalVentas+=elemento.getValor();
            cantNinos+=elemento.getCantNinos();
            cantAdultos+=elemento.getCantAdultos();
        }
         
         desc=(1-(totalVentas/ventas))*100;
         
        
        PdfPCell cell7 = new PdfPCell(new Paragraph("Totales",fontTablas));
        PdfPCell cell8 = new PdfPCell(new Paragraph(""));
        PdfPCell cell9 = new PdfPCell(new Paragraph(df.format(cantAdultos),fontTablas));
        PdfPCell cell10 = new PdfPCell(new Paragraph(df.format(cantNinos),fontTablas));
        PdfPCell cell11 = new PdfPCell(new Paragraph(df.format(ventas),fontTablas));
        PdfPCell cell12 = new PdfPCell(new Paragraph((df.format(desc)+"%"),fontTablas));
        PdfPCell cell13 = new PdfPCell(new Paragraph(df.format(totalVentas),fontTablas));
          table.addCell(cell7);
          table.addCell(cell8);
          table.addCell(cell9);
          table.addCell(cell10);
          table.addCell(cell11);
          table.addCell(cell12);
          table.addCell(cell13);
         
                    
        try
        {
            Image foto = Image.getInstance("Imagen1.jpg");
              foto.scaleToFit(200, 200);
               foto.setAlignment(Chunk.ALIGN_LEFT);
        //documento.add(foto);
        tablaEncabezado.addCell(foto);
        tablaEncabezado.addCell(titulo);
        documento.add(tablaEncabezado);
        documento.add(table);
        }
        catch ( Exception e )
        {
        e.printStackTrace();
        }
                      
              
       // documento.add(paragraph);

        
      onEndPage(writer,documento);
           
              
               
       documento.close();
        
       
        return ruta;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupPlanes = new javax.swing.ButtonGroup();
        lbTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbIndividual = new javax.swing.JRadioButton();
        rbPareja = new javax.swing.JRadioButton();
        rbCorp = new javax.swing.JRadioButton();
        rbFamiliar = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        lbPorcDesc = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtAdultos = new javax.swing.JTextField();
        txtNinos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbTotalPersonas = new javax.swing.JLabel();
        btnCalcular = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbValorNinos = new javax.swing.JLabel();
        lbValorAdultos = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnMenuPpal = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbValorTotal = new javax.swing.JLabel();
        lbTitulo1 = new javax.swing.JLabel();
        btnGenerarInforme = new javax.swing.JButton();
        lbId = new javax.swing.JLabel();
        lbId1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Tickets Zoologico Naturalvida");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Planes"));

        GroupPlanes.add(rbIndividual);
        rbIndividual.setSelected(true);
        rbIndividual.setText("Individual");
        rbIndividual.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbIndividualStateChanged(evt);
            }
        });

        GroupPlanes.add(rbPareja);
        rbPareja.setText("Pareja");
        rbPareja.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbParejaStateChanged(evt);
            }
        });
        rbPareja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParejaActionPerformed(evt);
            }
        });

        GroupPlanes.add(rbCorp);
        rbCorp.setText("Corporativo");
        rbCorp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbCorpStateChanged(evt);
            }
        });

        GroupPlanes.add(rbFamiliar);
        rbFamiliar.setText("Familiar");
        rbFamiliar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbFamiliarStateChanged(evt);
            }
        });
        rbFamiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbFamiliarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbPareja, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbCorp, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(rbIndividual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rbPareja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbFamiliar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbCorp)
                .addGap(12, 12, 12))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Descuento"));

        lbPorcDesc.setFont(new java.awt.Font("MV Boli", 1, 24)); // NOI18N
        lbPorcDesc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbPorcDesc.setText("0%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPorcDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbPorcDesc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("Adultos:");

        jLabel2.setText("Niños:");

        txtAdultos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtAdultos.setText("0");
        txtAdultos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAdultosFocusLost(evt);
            }
        });

        txtNinos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNinos.setText("0");
        txtNinos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNinosFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Total personas:");

        lbTotalPersonas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTotalPersonas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalPersonas.setText("0");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNinos)
                    .addComponent(txtAdultos)
                    .addComponent(lbTotalPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCalcular)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNinos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbTotalPersonas))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCalcular, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Valor entrada adultos:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Valor entrada  niños:");

        lbValorNinos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbValorNinos.setText("0");

        lbValorAdultos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbValorAdultos.setText("0");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnMenuPpal.setText("Menú Principal");
        btnMenuPpal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPpalActionPerformed(evt);
            }
        });

        btnSalir.setForeground(new java.awt.Color(255, 51, 51));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setText("Total");

        lbValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbValorTotal.setText("0");

        lbTitulo1.setFont(new java.awt.Font("Vivaldi", 1, 14)); // NOI18N
        lbTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo1.setText("Adultos: 10.000  -  Niños: 5.000");

        btnGenerarInforme.setText("Generar informe");
        btnGenerarInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarInformeActionPerformed(evt);
            }
        });

        lbId.setText("1");

        lbId1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbId1.setText("Ticket:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnMenuPpal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnGenerarInforme))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbId1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbId, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(lbValorAdultos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(lbValorNinos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(63, 63, 63))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(lbTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbId)
                    .addComponent(lbId1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbValorAdultos, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbValorNinos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(btnMenuPpal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGenerarInforme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbFamiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFamiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbFamiliarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
          System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMenuPpalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPpalActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ZoologicoMaven.MostrarVentanaPrincipal();
    }//GEN-LAST:event_btnMenuPpalActionPerformed

    private void rbParejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbParejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbParejaActionPerformed

    private void rbIndividualStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbIndividualStateChanged
        // TODO add your handling code here:
       
        if(rbIndividual.isSelected())
            lbPorcDesc.setText("0%");
        
    }//GEN-LAST:event_rbIndividualStateChanged

    private void rbFamiliarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbFamiliarStateChanged
        // TODO add your handling code here:
        if(rbFamiliar.isSelected())
            lbPorcDesc.setText("8%");
    }//GEN-LAST:event_rbFamiliarStateChanged

    private void rbCorpStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbCorpStateChanged
        // TODO add your handling code here:
        if(rbCorp.isSelected())
            lbPorcDesc.setText("10%");
    }//GEN-LAST:event_rbCorpStateChanged

    private void txtAdultosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAdultosFocusLost
        // TODO add your handling code here:
        
        if(txtAdultos.getText().equals(""))
            txtAdultos.setText("0");
        
       CalcularPersonas();
   
    }//GEN-LAST:event_txtAdultosFocusLost

    private void txtNinosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNinosFocusLost
        // TODO add your handling code here:
        
          if(txtNinos.getText().equals(""))
            txtNinos.setText("0");
        CalcularPersonas();
    
    }//GEN-LAST:event_txtNinosFocusLost

    
    private void HabilitarTxtCantPersonas(){
        txtAdultos.setEnabled(true);
        txtNinos.setEnabled(true);
    }
     private void InhabilitarTxtCantPersonas(){
        txtAdultos.setEnabled(false);
        txtNinos.setEnabled(false);
    }
     
     private void HabilitarRbPlanes(){
        rbIndividual.setEnabled(true);
        rbPareja.setEnabled(true);
        rbFamiliar.setEnabled(true);
        rbCorp.setEnabled(true);
    }
     private void InhabilitarRbPlanes(){
        rbIndividual.setEnabled(false);
        rbPareja.setEnabled(false);
        rbFamiliar.setEnabled(false);
        rbCorp.setEnabled(false);
    } 
     
    
    
    private void rbParejaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbParejaStateChanged
        // TODO add your handling code here:
        
        if(rbPareja.isSelected())
        {
            lbPorcDesc.setText("5%");
            InhabilitarTxtCantPersonas();
            txtAdultos.setText("2");
            txtNinos.setText("0");
            CalcularPersonas();
        }
        else
        {   
            HabilitarTxtCantPersonas();
        }
    }//GEN-LAST:event_rbParejaStateChanged

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        float ValorAdultos,ValorNinos,desc;
        
        
        InhabilitarRbPlanes();
        InhabilitarTxtCantPersonas();
        
        desc=Float.parseFloat(lbPorcDesc.getText().replace("%", ""))/100;
        ValorAdultos = Float.parseFloat(txtAdultos.getText())*10000 *(1-desc);
        lbValorAdultos.setText(df.format(ValorAdultos));
        ValorNinos = Float.parseFloat(txtNinos.getText())*5000* (1-desc);
        lbValorNinos.setText(df.format(ValorNinos));
        
        lbValorTotal.setText(df.format(ValorAdultos +ValorNinos));
        
    }//GEN-LAST:event_btnCalcularActionPerformed

    private void btnGenerarInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarInformeActionPerformed
        try {
            // TODO add your handling code here:
            
            adicional = new Adicional();
            adicional.MostrarPopUp("Informe generado correctamente en: "+GenerarInforme());
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaTicket.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(VentanaTicket.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnGenerarInformeActionPerformed

    
    public void Limpiar(){
         GroupPlanes.clearSelection();
        HabilitarRbPlanes();
        txtAdultos.setText("0");
        txtNinos.setText("0");
        
        lbValorAdultos.setText("0");
        lbValorNinos.setText("0");
        lbValorTotal.setText("0");
        lbTotalPersonas.setText("0");
        lbPorcDesc.setText("0%");
        HabilitarTxtCantPersonas();
    }
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
       Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        
            
        
        String tipoPlan;
        int cantAdultos=Integer.parseInt(txtAdultos.getText());
        int cantNinos=Integer.parseInt(txtNinos.getText());
        int descuento=Integer.parseInt(lbPorcDesc.getText().replace("%", ""));
        float valor=Float.parseFloat(lbValorTotal.getText().replace(".", ""));
        
        if(rbIndividual.isSelected())
        {
            tipoPlan="Individual";
        }
        else
        {
            if(rbPareja.isSelected())
            {
                tipoPlan="Pareja";
            }
            else
            {
                if(rbFamiliar.isSelected())
                {
                    tipoPlan="Familiar";
                }
                else
                {
                        tipoPlan="Corporativo";   
                }
            }
        }
        
        
        System.out.println(""+tipoPlan+" - "+ cantAdultos+" - "+ cantNinos+" - "+ descuento+" - "+ valor);
        plan = new Plan(tipoPlan, cantAdultos, cantNinos, descuento, valor,idTicket);
        arrayPlan.add(plan);
       System.out.println(""+arrayPlan.get(0).getTipoPlan()+" - "+ arrayPlan.get(0).getCantAdultos()+" - "+ arrayPlan.get(0).getCantNinos()+" - "+ arrayPlan.get(0).getDescuento()+" - "+ arrayPlan.get(0).getValor());
        arrayPlan.get(0).getCantAdultos();
        Limpiar();
        idTicket++;
        lbId.setText(Integer.toString(idTicket));
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    private void CalcularPersonas(){
         int adultos, ninos,total;
        adultos= Integer.parseInt(txtAdultos.getText());
        ninos=Integer.parseInt(txtNinos.getText());
        total=adultos+ninos;
        
        lbTotalPersonas.setText( Integer.toString(total) );
    }
    
    
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(VentanaTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(VentanaTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(VentanaTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(VentanaTicket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new VentanaTicket().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GroupPlanes;
    private javax.swing.JButton btnCalcular;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerarInforme;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenuPpal;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbId;
    private javax.swing.JLabel lbId1;
    private javax.swing.JLabel lbPorcDesc;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JLabel lbTitulo1;
    private javax.swing.JLabel lbTotalPersonas;
    private javax.swing.JLabel lbValorAdultos;
    private javax.swing.JLabel lbValorNinos;
    private javax.swing.JLabel lbValorTotal;
    private javax.swing.JRadioButton rbCorp;
    private javax.swing.JRadioButton rbFamiliar;
    private javax.swing.JRadioButton rbIndividual;
    private javax.swing.JRadioButton rbPareja;
    private javax.swing.JTextField txtAdultos;
    private javax.swing.JTextField txtNinos;
    // End of variables declaration//GEN-END:variables
}
