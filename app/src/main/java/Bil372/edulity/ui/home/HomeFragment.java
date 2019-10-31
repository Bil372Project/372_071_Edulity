package Bil372.edulity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Bil372.edulity.common.Schedule;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import Bil372.edulity.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        Map<Integer, TableRow> tableRows = new HashMap<>();

        final TableLayout table = root.findViewById(R.id.table_dersprogrami);
        //TODO: Get class's schedule object by class section from database
        //To test; this is random schedule for one class
        Schedule schedule = new Schedule("8-A");
        double maxStartTime = 0;
        for(Schedule.CourseInfo courseInfo : schedule.getCourseInfos()) {
            int key = (int)Math.round(Double.valueOf(courseInfo.getStartTime()));
            if(!tableRows.containsKey(key)) {// Check if this hour's row added to the table
                maxStartTime = Double.valueOf(courseInfo.getStartTime());
                TableRow row = new TableRow(inflater.getContext());
                row.setId(key);
                TextView textView = new TextView(inflater.getContext());
                textView.setText(courseInfo.getStartTime());
                row.addView(textView);
                for(int i = 0; i < 5; i++) {
                    row.addView(new TextView(inflater.getContext()));
                }
                tableRows.put(row.getId(),row);
            }
            TableRow row = tableRows.get(key);
            TextView textView = (TextView) row.getChildAt(courseInfo.getDay().getValue() + 1);
            textView.setText(courseInfo.getCourse().getName());

        }
        ArrayList<TableRow> rows = new ArrayList<>(tableRows.values());
        Collections.sort(rows, new Comparator<TableRow>() {
            @Override
            public int compare(TableRow tableRow, TableRow t1) {
                return new Integer(tableRow.getId()).compareTo(new Integer(t1.getId()));
            }
        });

        for(TableRow row: rows)
            table.addView(row);

        return root;
    }


}