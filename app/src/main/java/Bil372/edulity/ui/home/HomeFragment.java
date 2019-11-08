package Bil372.edulity.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import com.evrencoskun.tableview.TableView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Bil372.edulity.common.DataAccessor;
import Bil372.edulity.common.Schedule;
import Bil372.edulity.enums.Day;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import Bil372.edulity.R;

public class  HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private static DataAccessor accessor = new DataAccessor();
    private static View root;

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        if(root == null)
            root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        Map<Integer, TableRow> tableRows = new HashMap<>();

        TableLayout table = accessor.getScheduleTable();

        //TODO: Get class's schedule object by class section from database
        //To test; this is random schedule for one class
        Schedule schedule = DataAccessor.getSchedule();

        if(table == null){
            table = root.findViewById(R.id.mainTable);
            TableRow columnHeader = (TableRow) table.getChildAt(0);
            for(int i = 0; i < 5; i++)
                ((TextView)columnHeader.getChildAt(i + 1)).setText(Day.valueOf(i).name());
            for(Schedule.CourseInfo courseInfo : schedule.getCourseInfos()) {
                int key = (int)Math.round(Double.valueOf(courseInfo.getStartTime()));
                if(!tableRows.containsKey(key)) {// Check if this hour's row added to the table
                    TableRow row = new TableRow(table.getContext());
                    row.setId(key);
                    TextView textView = (TextView) getLayoutInflater().inflate(R.layout.row_header,null);
                    textView.setLayoutParams(new TableRow.LayoutParams(
                            0,
                            TableLayout.LayoutParams.MATCH_PARENT,
                            0.08f
                    ));
                    textView.setText(courseInfo.getStartTime());
                    row.addView(textView);
                    for(int i = 0; i < 5; i++) {
                        Button cell = (Button) getLayoutInflater().inflate(R.layout.cell,null);
                        cell.setLayoutParams(new TableRow.LayoutParams(
                                0,
                                TableLayout.LayoutParams.MATCH_PARENT,
                                0.1f
                        ));
                        cell.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch(View view, MotionEvent motionEvent) {
                                if(motionEvent.getAction() == 2) {
                                    view.setBackgroundResource(R.drawable.hovered_cell_background);
                                    ((Button)view).setTextColor(root.getResources().getColor(R.color.cell_background_color));
                                } else {
                                    view.setBackgroundResource(R.drawable.cell_background);
                                    ((Button)view).setTextColor(root.getResources().getColor(R.color.cell_text_color));
                                }
                                return false;
                            }
                        });
                        row.addView(cell);
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
                    return new Integer(tableRow.getId()).compareTo(Integer.valueOf(t1.getId()));
                }
            });

            for(TableRow row : rows)
                table.addView(row);
            accessor.setScheduleTable(table);
        }

        return root;
    }


}