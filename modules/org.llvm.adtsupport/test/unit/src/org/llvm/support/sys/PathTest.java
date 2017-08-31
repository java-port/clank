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

package org.llvm.support.sys;

import org.junit.Test;
import org.llvm.adt.ADTSupportTestBase;
import org.llvm.adt.SmallString;
import org.llvm.adt.StringRef;
import org.llvm.adt.Twine;
import org.llvm.support.impl.PathStatics;

/**
 *
 * @author Vladimir Voskresensky
 */
public class PathTest extends ADTSupportTestBase {
  private static final int PATH = 0;
  private static final int ROOT_DIRECTORY = 1;
  private static final int ROOT_NAME = 2;
  private static final int ROOT_PATH = 3;  
  private static final int FILENAME_POS = 4;  
  private static final String[][] DATA = new String[][] {
                // path to Check;       root_directory;       root_name;      root_path         filename_pos
    new String[] {"",                   "",                     "",               "",               "0"  },
    new String[] {"/",                  "/",                    "",               "/",              "0"  },
    new String[] {"/test-header.h",           "/",                  "",             "/",            "1"  },
    new String[] {"/goo/hello",               "/",                  "",               "/",          "5"  },
    new String[] {"c:/hello",                 "/",                  "c:",             "c:/",        "3"  },
    new String[] {"c:\\hello",                 "\\",                  "c:",             "c:\\",     "3"  },
    new String[] {"d/file.txt",               "",                   "",               "",           "2"  },
    new String[] {"//net/folder",             "/",                  "//net",          "//net/",     "6"  },
    new String[] {"//net",                    "",                  "//net",          "//net",       "0"  },
    new String[] {"\\\\VBOXSVR\\vk\\.bashrc", "\\",               "\\\\VBOXSVR",   "\\\\VBOXSVR\\",  "13"  },
    new String[] {"c:",                       "",                  "c:",             "c:",           "0"  },
                // path to Check;                   root_directory;   root_name;    root_path                  filename_pos
    new String[] {"rfs:vv@server:22",             "rfs:vv@server:22",     "",      "rfs:vv@server:22",             "16" },
    new String[] {"rfs:vk@avtovo:22/usr/include", "rfs:vk@avtovo:22/",    "",      "rfs:vk@avtovo:22/",            "21"  },
    new String[] {"rfs:vk@avtovo:22/usr",         "rfs:vk@avtovo:22/",    "",      "rfs:vk@avtovo:22/",            "17"  },
  };
  
  @Test
  public void test_root_directory() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    for (String[] strings : DATA) {
      StringRef check = new StringRef(strings[PATH]);
      String golden = strings[ROOT_DIRECTORY];
      StringRef result = path.root_directory(check); 
      ASSERT_EQ(golden, result);
    }
  }

  @Test
  public void test_root_name() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    for (String[] strings : DATA) {
      StringRef check = new StringRef(strings[PATH]);
      String golden = strings[ROOT_NAME];
      StringRef result = path.root_name(check); 
      ASSERT_EQ(golden, result);
    }
  }

  @Test
  public void test_root_path() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    for (String[] strings : DATA) {
      StringRef check = new StringRef(strings[PATH]);
      String golden = strings[ROOT_PATH];
      StringRef result = path.root_path(check);
      ASSERT_EQ(golden, result);
    }
  }

  @Test
  public void test_filename_pos() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    for (String[] strings : DATA) {
      StringRef check = new StringRef(strings[PATH]);
      String golden = strings[FILENAME_POS];
      String result = Integer.toString(PathStatics.filename_pos(check));
      ASSERT_EQ(golden, result);     
    }
  }

  @Test
  public void test_replace_extension() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    String[][] data = new String[][] {
      new String[] {"C:\\path\\test-file.h", "cpp", "C:\\path\\test-file.cpp"  },
      new String[] {"C:\\path\\test-file", "cpp", "C:\\path\\test-file.cpp"  },
      new String[] {"test-file.cpp", "h", "test-file.h"  },
      new String[] {"/dir/subdir/t.xxx", "h", "/dir/subdir/t.h"  },
    };    
    for (String[] strings : data) {
      final StringRef stringRef = new StringRef(strings[0]);
      SmallString testPath = new SmallString(stringRef, strings[0].length());
      String ext = strings[1];
      String golden = strings[2];      
      path.replace_extension(testPath, new Twine(ext));
      ASSERT_EQ(golden, testPath.toJavaString());
    }
  }
}
