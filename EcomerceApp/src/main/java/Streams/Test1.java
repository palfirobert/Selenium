package Streams;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    @Test
    public void regular()
    {
        ArrayList<String>names=new ArrayList<>();
        names.add("Tom");
        names.add("Gia");
        names.add("Robi");
        names.add("Adam");
        names.add("Andreea");
        int count=0;
        for(String name:names)
        {
            if(name.startsWith("A"))
                count++;
        }
        System.out.println(count);
    }
    @Test
    public void streamFilter()  // citeste tot paralel nu secvential
    {
        ArrayList<String>names=new ArrayList<>();
        names.add("Tom");
        names.add("Giorgia");
        names.add("Robi");
        names.add("Adam");
        names.add("Andreea");

        long count=names.stream().filter(s->s.startsWith("A")).count();//se face din aproape in aproape
        System.out.println(count);

        long size=Stream.of("Tom","Gia","Robi","Adam","Andreea").filter(s->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(size);

        //print all the names
        names.stream().filter(name->name.length()>4).forEach(name-> System.out.println(name));

        names.stream().filter(s->s.length()>4).limit(1).forEach(System.out::println);

    }

    @Test
    public void streamMap()
    {

        ArrayList<String>names1=new ArrayList<>();
        names1.add("Vasile");
        names1.add("Marius");
        names1.add("Salam");


        //print names of length>4 with uppercase
        Stream.of("Tom","Giorgia","Robi","Adam","Andreea").filter(name->name.length()>4).map(s->s.toUpperCase()).forEach(System.out::println);
        //cu map manipulam filterul

        List<String> names2= Arrays.asList("Tom","Giorgia","Robi","Adam","Andreea");
        names2.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase(Locale.ROOT)).forEach(System.out::println);

        //if Adam is present
        Stream<String>newStream=Stream.concat(names1.stream(),names2.stream());
        boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);


    }

    @Test
    public void streamCollect()// sa colectezi ce ai facut
    {
        List<String>ls=Stream.of("Tom","Giorgia","Robi","Adam","Andreea").filter(name->name.length()>4).map(s->s.toUpperCase()).collect(Collectors.toList());
        ls.stream().forEach(System.out::println);

        List<Integer>values=Arrays.asList(3,2,1,1,2,3,3,4);

        values.stream().distinct().forEach(System.out::println); //valorile distincte
    }
}
