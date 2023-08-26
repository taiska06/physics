package com.example.physics.Lesson;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.physics.Adapter.MyAdapterMexanic;
import com.example.physics.R;

import java.util.ArrayList;


public class MexanicFragment extends Fragment {

    private final String text[] = {
            "Механическое движение – изменение положения тела в пространстве с течением времени относительно других тел.\n"+
            "Траектория – любая линия движения тела. Путь S (м) – длина траектории.\n" +
                    "Перемещение S (м) – вектор, соединяющий начальное и конечное положение тела.\n" +
                    "S =х – х0 - модуль перемещения\n"+
                    "2. Скорость υ (м/с) – 1) \n средняя путевая υ = S/t \n 2) мгновенная - скорость в данной точке, может находиться только по уравнению скорости\n" +
                    "3.Ускорение а (м/с2)- изменение скорости за единицу времени \n ВИДЫ ДВИЖЕНИЙ \n *прямолинейное движение*",
            "*криволинейное движение*",
            "Сила (F) - векторная физическая величина, являющаяся количественной характеристикой действия одного тела на другое(или частей одного и того же тела). \n Сила характеризуется: \n 1. модулем \n 2. направлением \n 3. точкой приложения \n"+
            "Равнодействующая (результирующая) сила - сила, которая оказывает на тело такое же действие, как и несколько одновременно действующих сил, т.е. геометрическая сумма сил.",
            "Инерция - явление сохранения скорости тела при отсутсвии действия на него других тел (т.е покой или прямолинейное равномерное движение). \n Инерциальные системы отсчета - системы отсчета, относительно которых тело движется равномерно прямолинейно или покоится, если на него действуют другие тела. \n " +
                    "Инертность-свойство тел, характеризующее их способность сопротивляться изменению их скорости под воздействием силы. \n Масса - мера инертности тел.\n"+ "**МЕХАНИЧЕСКИЕ СИЛЫ** \n 1.Гравитационные силы действуют между всеми телами – все тела притягиваются друг к другу. Но это притяжение существенно лишь тогда, когда хотя бы одно из взаимодействующих сил так же велико, как Земля или луна.",
            "2.Электромагнитные силы действуют между заряженными частицами. В атомах, молекулах, живых организмах именно они являются главными.\n" +
                    "Область ядерных сил очень ограничена. Они заметны только внутри атомных ядер (т.е. на расстоянии 10-12 см.).  Слабые взаимодействия проявляются на ещё меньших расстояниях. Они вызывают превращение элементарных частиц друг в друга.   \n" +
                    "3.Основные виды сил: сила тяжести, сила трения, сила упругости.",
            "Силу притяжения тел к Земле вблизи ее поверхности называют сила тяжести.\n" +
                    "\n" +
                    "Fтяж = m·g   \n" +
                    "\n" +
                    "Сила тяжести всегда направлена вертикально вниз к поверхности Земли. Сила тяжести направлена к центру Земли. Сила тяжести это гравитационная сила, приложенная к центру тела.",
            "Сила трения - это сила, возникающая при движении одного тела по поверхности другого, приложенная к движущемуся телу и направлена против движения.\n" +
                    "\n" +
                    "Сила трения - это сила электромагнитной природы.\n" +
                    "\n" +
                    "Возникновение силы трения объясняется двумя причинами:\n" +
                    "\n" +
                    "1) Шероховатостью поверхностей\n" +
                    "2) Проявлением сил молекулярного взаимодействия.\n" +
                    "\n" +
                    "Силы трения всегда направлены по касательной к соприкасающимся поверхностям и подразделяются на силы трения покоя, силы трения скольжения, силы трения качения.\n" +
                    "\n" +
                    "Fтр = м*N, где м – коэффициент трения , N – сила реакции опоры.",
            "Сила упругости – сила, которая возникает при любом виде деформации тел и стремится вернуть тело в первоначальное состояние.  \n" +
                    "\n" +
                    "Fупрx = - k*x, где k – жесткость тела [Н/м], х - абсолютное удлинение тела.\n" +
                    "\n" +
                    "Сила упругости перпендикулярна поверхности взаимодействующих тел и направлена всегда против деформации."

    };

    private final String image_urls[] = {
            "https://дмш-самрина.рф/800/600/http/jimdo-storage.freetls.fastly.net/image/18856390/6adc4c92-dc7e-4e97-a2d2-207a0369d4c2.jpg?format=pjpg&quality=80,90&auto=webp&disable=upscale&width=960&height=504&crop=1:0.525",
            "https://egevip.ru/wp-content/uploads/202020/03/krivo.jpg",
            "https://studfile.net/html/2706/352/html_rezQNY4j6G.Ffvw/img-5y3OA5.png",
            "https://sun9-56.userapi.com/s/v1/ig2/1J1jFcP8s76Gi9s0ZWwyTzVWB24N5kSnxUmSTDp5hUGOT_NEdouMC4DGv20BdM4pzCsSp61UShbBupitNPoVe5Ms.jpg?size=604x340&quality=95&type=album",
            "https://otvet.imgsmail.ru/download/287691196_a3d8ead766b81e7a04acccabda89d699_800.jpg",
            "https://avatars.dzeninfra.ru/get-zen_doc/1710676/pub_629215eeaaecdd3346c6aa3d_62921935fc0cdb4cd9bb21e3/scale_1200",
            "https://present5.com/presentation/-53764314_183039443/image-3.jpg",
            "https://doc4web.ru/uploads/files/75/75358/hello_html_m9b37b89.png"

    };



    public MexanicFragment() {
        // Required empty public constructor
    }


    public static MexanicFragment newInstance() {
        MexanicFragment fragment = new MexanicFragment();

        return fragment;
    }

    private ArrayList<MexanicFragment.WeatherItem> generateData() {
        ArrayList<MexanicFragment.WeatherItem> list = new ArrayList<>();
        for(int i = 0; i< text.length; i++) {
            list.add(new WeatherItem(text[i],image_urls[i]));
        }
        return list;
    }
    public class WeatherItem {
        private String name;
        private String url;

        public WeatherItem(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view= inflater.inflate(R.layout.fragment_mexanic, container, false);;
        RecyclerView recyclerView =  view.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyAdapterMexanic(generateData()));
        return view;

    }
}
