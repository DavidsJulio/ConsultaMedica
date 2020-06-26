package com.davidjulio.consultamedica.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.davidjulio.consultamedica.R;
import com.davidjulio.consultamedica.helper.DbHelper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPatients extends RecyclerView.Adapter <AdapterPatients.MyViewHolder> {
    //recebe uma viewHolder (os itens que passam no recyclerView são exibidos numa ViewHolder)
    //o recycler view tem a função de reciclar as visualizações

    DbHelper mybd; //variavel da dbhelper para poder chamar os index da coluna

    private Context pContext;
    private Cursor pCursor;
    private MyViewHolder viewHolderPaciente = null;

    public AdapterPatients(Context context, Cursor cursor) { //constructor automatico generate - constructor (alterado)
        pContext = context; //a variavel a receber os respetivos valores
        pCursor = cursor;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //criar as visualizações
                                                                                             //parent é o compontente onde a nossa list se encontra
        View listPatients = LayoutInflater.from(parent.getContext())                         //converter um xml em uma View
                            .inflate(R.layout.adapter_patients, parent, false); //vamos buscar o nosso xml

        return new MyViewHolder( listPatients ); //retornar a nossa classe MyViewHolder um parametro View (itemLista)
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //exibe os elementos das visualizações

        if (!pCursor.moveToPosition(position)){ //condição para garantir que o cursor consegue mover para a "position"
            return;
        }

        String name = pCursor.getString(pCursor.getColumnIndex(mybd.NOME_PACIENTE)); //chamamos getString para ler a string da nossa BD, chamamos o nosso cursor
        String tele = pCursor.getString(pCursor.getColumnIndex(mybd.TELE_PACIENTE)); //e vamos buscar o columnIndex (numero correspondente à tabela pertendida)
        String data = pCursor.getString(pCursor.getColumnIndex(mybd.DATA_PACIENTE)); //neste caso as tabelas encontram se na DbHelper
        String city = pCursor.getString(pCursor.getColumnIndex(mybd.CIDADE_PACIENTE));
        String resultado = pCursor.getString(pCursor.getColumnIndex(mybd.RESULTADO_PACIENTE));

        holder.namePatient.setText(name); //vamos buscar o holder das respetivas tv e colocamos o valor pretendido
        holder.phonePatient.setText(tele);
        holder.bDatePatient.setText(data);
        holder.cityPatient.setText(city);
        holder.resultPatient.setText(resultado);
    }

    @Override
    public int getItemCount() { //quantidade de items da recyclerView

        return pCursor.getCount(); //contagem dos dados da bd
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView namePatient, phonePatient, bDatePatient, cityPatient, resultPatient;

        public MyViewHolder(@NonNull View itemView) { //construtor criado automaticamente
            super(itemView);
                        //precisamos do itemView porque é ele que acessa os componentes (id's)
            namePatient = itemView.findViewById(R.id.tvNomePatient);
            phonePatient = itemView.findViewById(R.id.tvPhonePatient);
            bDatePatient = itemView.findViewById(R.id.tvBdatePatient);
            cityPatient = itemView.findViewById(R.id.tvCityPatient);
            resultPatient = itemView.findViewById(R.id.tvResultPatient);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (viewHolderPaciente == this) {
                return;
            }
            if (viewHolderPaciente != null) {
                viewHolderPaciente.deSelecionaPaciente();
            }
            viewHolderPaciente = this;
            selecionaPaciente();

        }
        public void selecionaPaciente(){
            itemView.setBackgroundResource(R.color.colorAccent);

        }

        private void deSelecionaPaciente(){
            itemView.setBackgroundResource(R.color.colorWhite);
        }
    }

    public void mudarCursor(Cursor newCursor){ //
        if(pCursor != null)
            pCursor.close(); //se o cursor que temos não é null fechamos

        pCursor = newCursor; //atribuimos o novo cursor ao já existente

        if (newCursor != null)
            notifyDataSetChanged(); //este dado vai atualizar a recycler view
    }
}
