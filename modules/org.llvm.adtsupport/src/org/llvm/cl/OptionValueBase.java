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

/*template <class DataType, bool isClass> TEMPLATE*/

// The default value safely does nothing. Option value printing is only
// best-effort.
//<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueBase">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 362,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueBase")
//</editor-fold>
public class/*struct*/ OptionValueBase</*class*/ DataType>  extends /*public*/ OptionValueCopy<DataType> implements Destructors.ClassWithDestructor {

  private final boolean isClass = true; // we always use java objects in options so far (Integer, etc. instead of primitive types)

//  // Temporary storage for argument passing.
//  /*typedef OptionValue<DataType> WrapperType*/
////  public final class WrapperType extends OptionValue<DataType>{ };
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueBase::hasValue">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 367,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueBase::hasValue")
//  //</editor-fold>
//  public boolean hasValue() /*const*/ {
//    return super.hasValue();
//  }
//
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueBase::getValue">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 369,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueBase::getValue")
//  //</editor-fold>
//  public /*const*/ DataType /*&*/ getValue() /*const*/ {
//    return super.getValue();
//  }
//
//
//  // Some options may take their value from a different data type.
//  /*template <class DT> TEMPLATE*/
//  /*V*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueBase::setValue">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 373,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueBase::setValue")
//  //</editor-fold>
//  public /*<class DT>*/ void setValue(/*const*/ DataType /*&*/ $Prm0) {
//    super.setValue($Prm0); // I'm keeping this just to be able to navigate to the original code
//  }
//
//
//  /*V*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueBase::compare">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 375,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueBase::compare")
//  //</editor-fold>
//  public boolean compare(/*const*/ DataType /*&*/ $Prm0) /*const*/ {
//    return false;
//  }
//
//
//  /*V*/
//  //<editor-fold defaultstate="collapsed" desc="llvm::cl::OptionValueBase::compare">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 377,
//   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::OptionValueBase::compare")
//  //</editor-fold>
//  @Override public /*virtual*/ boolean compare(/*const*/ GenericOptionValue /*&*/ $Prm0) /*const*/ {
//    return false;
//  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "{" + "isClass=" + isClass + "," + super.toString() + '}';
  }
}
