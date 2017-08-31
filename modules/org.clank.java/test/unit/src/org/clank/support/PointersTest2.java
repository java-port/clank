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


package org.clank.support;

import org.clank.support.aliases.*;
import org.junit.Test;

/**
 *
 * @author petrk
 */
public class PointersTest2 extends org.clank.java.JavaTestBase {
    
    private static final String GOLDEN_DATA = "111000101111\n" +
                                              "true\n" +
                                              "false\n" +
                                              "true";
    
    /* 
    int globalVar1 = 0;
    int globalVar2 = 1;
    */
    
    int globalVar1 = 0;    
    
    int$memory $globalVar1 = new int$varmem() {

        @Override
        public int get() {
            return globalVar1;
        }

        @Override
        public void set(int value) {
            globalVar1 = value;
        }

      @Override
      public int $set$addassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$minusassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$andassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$xorassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$orassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$starassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$slashassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$modassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$lshiftassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$rshiftassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$postInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$postDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$preInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$preDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
        
    };
    
    int globalVar2 = 0;
    
    int$memory $globalVar2 = new int$varmem() {
            
        @Override
        public int get() {
            return globalVar2;
        }

        @Override
        public void set(int value) {
            globalVar2 = value;
        }

      @Override
      public int $set$addassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$minusassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$andassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$xorassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$orassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$starassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$slashassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$modassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$lshiftassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$rshiftassign(int index, int value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$postInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$postDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$preInc(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }

      @Override
      public int $set$preDec(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      }
            
    };
    
    /*
    void changeVar(int *ptr) {
      *ptr = 1;
    }
    */
    
    void changeVar(int$ptr ptr) {
        ptr.$set(1);
    }

    
    /*
    void changeVar(int **ptr) {
      *ptr = &$globalVar2;
    }
    */    
    
    void changePtr(type$ptr<int$ptr> ptr) {
      ptr.$set(new int$ptr$heavy($globalVar2));
    }
    

    @Test
    public void testHeavyPointers2() {
        if (markAsSkippedIfNeed(TestState.Successful)) { return; }
        StringBuilder sb = new StringBuilder();
        
        /*
        int *a = &globalVar1;
        int **b = &a;   
        */
        
        int$ptr a = new int$ptr$heavy($globalVar1);
        type$ptr<int$ptr> b = a.$addr();

        /*
        changeVar(b);
        */
        
        changeVar(a);

        sb.append(a.$star()).append(b.$star().$star()).append(globalVar1).append(globalVar2);

        /*
        changePtr(&a);
        */
        changePtr(a.$addr());
        
        sb.append(a.$star()).append(b.$star().$star()).append(globalVar1).append(globalVar2);
        
        /*
        changeVar(a);
        */     
        changeVar(a);
        
        sb.append(a.$star()).append(b.$star().$star()).append(globalVar1).append(globalVar2);      

        sb.append("\n");

        /*
        (b == &a) ? "true" : "false"
        (a == &globalVar1) ? "true" : "false"
        (a == &globalVar2) ? "true" : "false"
        */
        sb.append(b.$eq(a.$addr())).append("\n")
          .append(a.$eq(new int$ptr$heavy($globalVar1))).append("\n")
          .append(a.$eq(new int$ptr$heavy($globalVar2)));
        
        ASSERT_EQ(GOLDEN_DATA, sb.toString());
    }
}


/*
#include <iostream>

int globalVar1 = 0;
int globalVar2 = 0;

struct AAA {
  
};

struct BBB : AAA {
  
};

AAA*  p = new AAA[100];
AAA *p2 = &p[10];

int foo() {
  p[10] = AAA();
}

void changeVar(int *ptr) {
  *ptr = 1;
}

void changePtr(int **ptr) {
  *ptr = &globalVar2;
}

int main() {
  int *a = &globalVar1;
  int **b = &a;
  
  changeVar(a);
  std::cout << *a << std::endl;
  std::cout << **b << std::endl;
  std::cout << globalVar1 << std::endl;
  std::cout << globalVar2 << std::endl;
  
  changePtr(&a);
  std::cout << *a << std::endl;
  std::cout << **b << std::endl;
  std::cout << globalVar1 << std::endl;
  std::cout << globalVar2 << std::endl;  
  
  changeVar(a);
  std::cout << *a << std::endl;
  std::cout << **b << std::endl;
  std::cout << globalVar1 << std::endl;
  std::cout << globalVar2 << std::endl;  
  
  std::cout << ((b == &a) ? "true" : "false") << std::endl;  
  std::cout << ((a == &globalVar1) ? "true" : "false") << std::endl;  
  std::cout << ((a == &globalVar2) ? "true" : "false") << std::endl;  
  
  return 0;
}
*/