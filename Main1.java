import java.util.*;
public class Main
{
  public static void main (String[]args)
  {
    Scanner sc = new Scanner (System.in);
    int ts = sc.nextInt ();
    int currentIndex = -1;
    int inactive_ele_size = sc.nextInt ();

    char[] iele = new char[inactive_ele_size];
    for (int i = 0; i < inactive_ele_size; i++)
      {
	iele[i] = sc.next ().charAt (0);
      }

    String[] task = new String[ts];
    Queue < String > que = new ArrayDeque <> ();
    for (int i = 0; i < ts; i++)
      {
	task[i] = sc.next ();
	que.add (task[i]);
      }

    for (int i = 1; i < ts; i++)
      {
	if (task[0].charAt (0) == task[i].charAt (0))
	  {
	    currentIndex = i;
	    break;
	  }
      }

    String[]ctask = new String[ts];
    for (int i = 0; i < ts; i++)
      {
	ctask[i] = task[i];
      }

    for (int i = 0; i < inactive_ele_size; i++)
      {
	for (int j = 0; j < ts; j++)
	  {
	    if (iele[i] == task[j].charAt (0))
	      {
		ctask[j] = "0";
	      }
	  }
      }
    int s = 0;
    for (int i = 0; i < ts; i++)
      {
	if (ctask[i] != "0")
	  {
	    s++;
	  }
      }
    int nsize = ts - s;
    int z = 0;
    String[]newtask = new String[nsize];
    for (int i = 0; i < ts; i++)
      {
	if (ctask[i] != "0")
	  {
	    newtask[z] = ctask[i];
	    z++;
	  }
      }


    int outindex = findIndex (task, newtask, currentIndex);
    System.out.println (outindex);

  }
  public static int findIndex (String[]oldQueue, String[]newQueue,
			       int currentIndexMember)
  {
    int index = 0;
    int oldIndex = 0;
  for (String s:oldQueue)
      {
	if (s.equals (currentIndexMember))
	  {
	    oldIndex = index;
	    break;
	  }
	index++;
      }
    index = 0;
  for (String s:newQueue)
      {
	if (oldIndex == 0)
	  {
	    break;
	  }
	if (s.equals (currentIndexMember))
	  {
	    oldIndex--;
	  }
	index++;
      }
    return index;
  }
}
