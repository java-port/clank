/**
 * This file was converted to Java from the original LLVM source file. The original
 * source file follows the LLVM Release License, outlined below.
 * 
 * ==============================================================================
 * LLVM Release License
 * ==============================================================================
 * University of Illinois/NCSA
 * Open Source License
 * 
 * Copyright (c) 2003-2017 University of Illinois at Urbana-Champaign.
 * All rights reserved.
 * 
 * Developed by:
 * 
 *     LLVM Team
 * 
 *     University of Illinois at Urbana-Champaign
 * 
 *     http://llvm.org
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal with
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 *     * Redistributions of source code must retain the above copyright notice,
 *       this list of conditions and the following disclaimers.
 * 
 *     * Redistributions in binary form must reproduce the above copyright notice
 *       this list of conditions and the following disclaimers in the
 *       documentation and/or other materials provided with the distribution.
 * 
 *     * Neither the names of the LLVM Team, University of Illinois at
 *       Urbana-Champaign, nor the names of its contributors may be used to
 *       endorse or promote products derived from this Software without specific
 *       prior written permission.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.  IN NO EVENT SHALL THE
 * CONTRIBUTORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS WITH THE
 * SOFTWARE.
 * 
 * ==============================================================================
 * Copyrights and Licenses for Third Party Software Distributed with LLVM:
 * ==============================================================================
 * The LLVM software contains code written by third parties.  Such software will
 * have its own individual LICENSE.TXT file in the directory in which it appears.
 * This file will describe the copyrights, license, and restrictions which apply
 * to that code.
 * 
 * The disclaimer of warranty in the University of Illinois Open Source License
 * applies to all code in the LLVM Distribution, and nothing in any of the
 * other licenses gives permission to use the names of the LLVM Team or the
 * University of Illinois to endorse or promote products derived from this
 * Software.
 * 
 * The following pieces of software have additional or alternate copyrights,
 * licenses, and/or restrictions:
 * 
 * Program             Directory
 * -------             ---------
 * Autoconf            llvm/autoconf
 *                     llvm/projects/ModuleMaker/autoconf
 * Google Test         llvm/utils/unittest/googletest
 * OpenBSD regex       llvm/lib/Support/{reg*, COPYRIGHT.regex}
 * pyyaml tests        llvm/test/YAMLParser/{*.data, LICENSE.TXT}
 * ARM contributions   llvm/lib/Target/ARM/LICENSE.TXT
 * md5 contributions   llvm/lib/Support/MD5.cpp llvm/include/llvm/Support/MD5.h
 */


package org.clank.java;

import static org.clank.support.Casts.reinterpret_cast;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.char$ptr;
import org.clank.support.aliases.ulong$ptr;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class StdStringTest extends JavaTestBase {
  
  private std.string str;
  
  @Before
  public void before() {
    str = new std.string("Hello, World!");
  }

  @Test
  public void testResize() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    final std.string str5Spaces = new std.string("     ");
    EXPECT_EQ(str5Spaces, new std.string(5, $$SPACE));
    EXPECT_EQ(str5Spaces, new std.string(5, ' '));
    std.string myStr1 = new std.string();
    myStr1.resize(5, ' ');
    EXPECT_EQ(str5Spaces, myStr1);
  }
  
  @Test
  public void testReplace1() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    str.replace(7, 5, $("someone"), "someone".length());
    EXPECT_EQ(new std.string("Hello, someone!"), str);
  }
  
  @Test
  public void testReplace2() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    str.replace(6, 6, str.data(), 5);
    EXPECT_EQ(new std.string("Hello,Hello!"), str);
  }
  
  @Test
  public void testReplace3() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    str.replace(6, 6, str.data().$add(7), 5);
    EXPECT_EQ(new std.string("Hello,World!"), str);
  }  
  
  @Test
  public void testReplaceHard() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string base=new std.string("this is a test string.");
    std.string str2=new std.string("n example");
    std.string str3=new std.string("sample phrase");
    std.string str4=new std.string("useful.");

    // replace signatures used in the same order as described above:

    // Using positions:                 0123456789*123456789*12345
    std.string str = $tryClone(base);           // "this is a test string."
    str.replace(9,5,str2);          // "this is an example string." (1)
    str.replace(19,6,str3,7,6);     // "this is an example phrase." (2)
    str.replace(8,10,"just a");     // "this is just a phrase."     (3)
    str.replace(8,6,"a shorty",7);  // "this is a short phrase."    (4)
    str.replace(22,1,3,'!');        // "this is a short phrase!!!"  (5)
    
    EXPECT_EQ(new std.string("this is a short phrase!!!"), str);

    // Using iterators:                                               0123456789*123456789*
    str.replace(str.begin(),str.end().$sub(3),str3);                    // "sample phrase!!!"      (1)
    str.replace(str.begin(),str.begin().$add(6),"replace");             // "replace phrase!!!"     (3)
    str.replace(str.begin().$add(8),str.begin().$add(14),"is coolness",7);    // "replace is cool!!!"    (4)
    str.replace(str.begin().$add(12),str.end().$sub(4),4,'o');                // "replace is cooool!!!"  (5)
    str.replace(str.begin().$add(11),str.end(),str4.begin(),str4.end());// "replace is useful."    (6)
    
    EXPECT_EQ(new std.string("replace is useful."), str);
  }
  
  @Test
  public void testRFind() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string str = new std.string("The sixth sick sheik's sixth sheep's sick.");
    std.string key = new std.string("sixth");

    int found = str.rfind(key);
    if (found!=std.string.npos) {
      str.replace (found,key.length(),"seventh");
    }

    EXPECT_EQ(new std.string("The sixth sick sheik's seventh sheep's sick."), str);
  }
  
  @Test
  public void testFind() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string str = new std.string("There are two needles in this haystack with needles.");
    std.string str2 = new std.string("needle");

    // different member versions of find in the same order as above:
    int found = str.find(str2);
    EXPECT_EQ(14, found);

    found=str.find("needles are small",found+1,6);
    EXPECT_EQ(44, found);

    found=str.find("haystack");
    EXPECT_EQ(30, found);

    found=str.find('.');
    EXPECT_EQ(51, found);

    // let's replace the first needle:
    str.replace(str.find(str2),str2.length(),"preposition");
    EXPECT_EQ(new std.string("There are two prepositions in this haystack with needles."), str);
  }
  
  @Test
  public void testAddAssign() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string golden = new std.string("__attribute__((__cdecl__))");
    {
      std.string GCCSpelling = new std.string($("__attribute__((__"));
      GCCSpelling.$addassign($("cdecl"));
      GCCSpelling.$addassign($("__))"));    
      EXPECT_EQ(golden, GCCSpelling);
    }
    {
      std.string GCCSpelling = new std.string($("__attribute__((__"));
      GCCSpelling.$addassign(new std.string($("cdecl")));
      GCCSpelling.$addassign(new std.string($("__))")));    
      EXPECT_EQ(golden, GCCSpelling);
    }
  }
  
  @Test 
  public void testReplace() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String ORIG = "1234567890        ;";
    std.string golden = new std.string(ORIG);
    golden.replace(0, std.string.npos, "");
    EXPECT_EQ(golden, "");
    golden = new std.string(ORIG);
    golden.replace(9, std.string.npos, "...");
    String javaReplaced = ORIG.substring(0, 9) + "...";
    EXPECT_EQ(golden, javaReplaced);
  }

  @Test 
  public void testLess() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string NotEmpty = new std.string("console");
    std.string Empty = new std.string("");
    ASSERT_FALSE(NotEmpty.$less(Empty));
    ASSERT_TRUE(Empty.$less(NotEmpty));
  }
  
  @Test
  public void testFindFirstOf() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.string str = new std.string("Hello World!");
    std.string search_str = new std.string("o");
    char$ptr search_cstr = create_char$ptr("Good Bye!");
    ASSERT_EQ(4, str.find_first_of(search_str));
    ASSERT_EQ(7, str.find_first_of(search_str, 5));
    ASSERT_EQ(1, str.find_first_of(search_cstr));
    ASSERT_EQ(4, str.find_first_of(search_cstr, 0, 4));
    // 'x' is not in "Hello World', thus it will return std::string::npo
    ASSERT_EQ(std.string.npos, str.find_first_of($('x')));
  }
}
