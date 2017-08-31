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

package org.llvm.cl;

import org.clank.support.Converted;
import org.clank.support.*;
import static org.clank.support.Native.*;

// Simple copy of the option value.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueCopy">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 381,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueCopy")
//</editor-fold>
public class OptionValueCopy</*class*/ DataType>  extends /*public*/ GenericOptionValue implements Destructors.ClassWithDestructor {
  private DataType Value;
  private boolean Valid;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueCopy::OptionValueCopy<DataType>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 386,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueCopy::OptionValueCopy<DataType>")
  //</editor-fold>
  public OptionValueCopy() {
    /* : Valid(false)*/
    //START JInit
    this.Valid = false;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueCopy::hasValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 388,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueCopy::hasValue")
  //</editor-fold>
  public boolean hasValue() /*const*/ {
    return Valid;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueCopy::getValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 390,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueCopy::getValue")
  //</editor-fold>
  public /*const*/ DataType /*&*/ getValue() /*const*/ {
    assert (Valid) : "invalid option value";
    return Value;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueCopy::setValue">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 395,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueCopy::setValue")
  //</editor-fold>
  public void setValue(/*const*/ DataType /*&*/ V) {
    Valid = true;
    Value = V;
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueCopy::compare">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 420,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 397,
   FQN = "llvm::cl::OptionValueCopy::compare", NM = "_ZNK4llvm2cl15OptionValueCopy7compareERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=_ZNK4llvm2cl15OptionValueCopy7compareERKT_")
  //</editor-fold>
  public boolean compare(/*const*/ DataType /*&*/ V) /*const*/ {
    return Valid && ($noteq(Value, V));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueCopy::compare">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 401,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueCopy::compare")
  //</editor-fold>
  @Override public /*virtual*/ boolean compare(/*const*/ GenericOptionValue /*&*/ V) /*const*/ {
    /*const*/ OptionValueCopy<DataType> /*&*/ VC = (/*static_cast*//*const*/ OptionValueCopy<DataType> /*&*/ )(V);
    if (!VC.hasValue()) {
      return false;
    }
    return compare(VC.getValue());
  }

  @Override
  public String toString() {
    return "Value=" + Value + ", Valid=" + Valid;
  }
}
