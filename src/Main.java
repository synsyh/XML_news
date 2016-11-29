import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * Created by huozongsheng on 10/16/16.
 * before use
 * 1.creatXml
 * 2.set informations
 * 3.addCharacters
 * 4.write_news
 * 5.Agree
 * */

public class Main {
    public static void main(String[] args) throws IOException, DocumentException {
        Role s = new Role();

//        s.createXml("art", "test");

        s.setJournalistName("Huozongsheng");
        s.setEditorName("Sunyuning");
        s.setChiefname("Yangliu");
        s.setJournalistID("1");
        s.setEditorID("2");
        s.setChiefID("3");
        s.addCharacters("Sports", "China launches manned spacecraft");
        s.write_news("Sports", "China launches manned spacecraft","China launched the Shenzhou XI manned spacecraft on Monday morning to transport two astronauts to the Tiangong II space laboratory.\n" +
                "\n" +
                "The spacecraft was sent skyward at 7:30 am atop a Long March 2F rocket from the Jiuquan Satellite Launch Center in Northwest China. It is carrying two male astronauts – 49-year-old Jing Haipeng and 37-year-old Chen Dong.\n" +
                "\n" +
                "After the launch, the spacecraft will travel two days before docking with the Tiangong II, which was lifted from the Jiuquan center in mid-September. Then the astronauts will enter the space lab and stay there for 30 days, which will be the longest space stay by Chinese astronauts.\n" +
                "\n" +
                "The core tasks of the Shenzhou XI mission are to test rendezvous and docking technologies for the country's planned space station, to verify the life-support capability of the spacecraft-space lab combination as well as conduct scientific research and test engineering experiments, according to Wu Ping, deputy director of the China Manned Space Agency.\n" +
                "\n" +
                "Prior to the Shenzhou XI, China had sent five spacecraft and 10 astronauts to space since 2003, when it lifted the Shenzhou V to carry the nation's first astronaut Yang Liwei, who is now a senior space official, into space.\n" +
                "\n" +
                "China is the third country in the world that has independently fulfilled manned spaceflight following the former Soviet Union and the United States.\n" +
                "\n" +
                "China's manned space program, a source of national pride, aims to place a permanent manned space station, which will consist of three parts — a core module attached to two labs, each weighing about 20 metric tons —into service around 2022, according to the manned space agency.\n" +
                "\n" +
                "Lab shows early results\n" +
                "\n" +
                "After being launched into orbit on Sept 15, the scientific applications of the Tiangong II space laboratory have been tested and have returned data. Here are some of the results:\n" +
                "\n" +
                "・ The cold atomic space clock, the first of its kind in space, has carried out several tests with stable results, as expected. Scientists believe that such a clock can help to synchronize other atomic clocks more precisely, and that the technological development will create more possibilities for further explorations in space.\n" +
                "\n" +
                "・ The multi-angle wide-spectral imager has captured a range of information on oceans and land as well as changes to clouds, aerosols and water.\n" +
                "\n" +
                "・ The stereoscopic microwave altimeter has applied interference image technology to observe sea surfaces, parts of the Yellow River, the Taklimakan Desert, lakes on the Tibetan Plateau and the Lancang-Mekong River.\n" +
                "\n" +
                "・ An agricultural experiment has sprouted seeds of Arabidopsis thaliana, a small flowering plant, and rice. Samples will be cultivated in space and carried back to the Earth by astronauts.\n" +
                "\n" +
                "・ The space-Earth quantum key distribution and laser communications experiment has established stable connections between the space lab and ground stations.");
        s.Agree("Sports", "China launches manned spacecraft","N","Editor");
        s.Agree("Sports", "China launches manned spacecraft","Y","Chief");
        s.History("Sports", "China launches manned spacecraft","Editor","Test history");
        System.out.println("Programm Finished");
    }
}
