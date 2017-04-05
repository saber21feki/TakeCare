package com.epsi.takecare;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by eugeniebenezech on 05/04/2017.
 */

public class PatientAdapter extends ArrayAdapter<Patient> {

    public PatientAdapter(Context context, List<Patient> patients) {
        super(context, 0, patients);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_patient,parent, false);
        }

        PatientViewHolder viewHolder = (PatientViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new PatientViewHolder();
            viewHolder.nom_patient = (TextView) convertView.findViewById(R.id.nomPatientList);
            viewHolder.prenom_patient = (TextView) convertView.findViewById(R.id.prenomPatientList);
            viewHolder.date_naissance = (TextView) convertView.findViewById(R.id.datePatientList);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Patient> patients
        Patient patient = getItem(position);
        viewHolder.nom_patient.setText(patient.getNom_patient());
        viewHolder.prenom_patient.setText(patient.getPrenom_patient());
        viewHolder.date_naissance.setText((CharSequence) patient.getDate_naissance());

        return convertView;
    }

    private class PatientViewHolder{
        public TextView nom_patient;
        public TextView prenom_patient;
        public TextView date_naissance;

    }
}
