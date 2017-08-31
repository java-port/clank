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

import org.clank.support.*;
import org.clank.support.aliases.*;

/*template <class DataType, bool ExternalStorage, bool isClass> TEMPLATE*/

// Originally, there is a multiple inheritaance.
// So we create a pair: opt_storage interface and opt_storage_impl implemmentation
// to delegate functionality to

//===----------------------------------------------------------------------===//
// opt_storage class

// Default storage class definition: external storage.  This implementation
// assumes the user will specify a variable to store the data into with the
// cl::location(x) modifier.
//
//<editor-fold defaultstate="collapsed" desc="llvm::cl::opt_storage">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1116,
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt_storage")
//</editor-fold>
public class opt_storage_impl_internal<DataType> implements opt_storage</*class*/ DataType>  {


  private final boolean isClass = true;

  private DataType Value;
  private final OptionValue<DataType> Default;

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt_storage::opt_storage<DataType, ExternalStorage, isClass>">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1064,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt_storage::opt_storage<DataType, ExternalStorage, isClass>")
  //</editor-fold>
  public opt_storage_impl_internal(DataType DV) {
    Value = DV;
    this.Default = new OptionValue<>(DV);
  }


  public boolean setLocation(Option /*&*/ O, type$ref<DataType> /*&*/ L) {
    assert false : "setLocation is supported only for external storages. Forgot to init with initialized with opt.StorageKind.External?";
    return false;
  }

  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt_storage::setValue">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1075,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt_storage::setValue")
  //</editor-fold>
  public void setValue(/*const T &*/ DataType V) {
    setValue(V, false);
  }

  public /*<class T>*/ void setValue(/*const T &*/ DataType V, boolean initial/*= false*/) {
    Value = V;
    if (initial) {
      Default.$assign(V);
    }
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt_storage::getValue">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", old_line = 1082,
   FQN = "llvm::cl::opt_storage<type-parameter-0-0, false, true>::setValue", NM = "Tpl__ZN4llvm2cl11opt_storageIT_Lb0ELb1EE8setValueERKT_b",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -nm=Tpl__ZN4llvm2cl11opt_storageIT_Lb0ELb1EE8setValueERKT_b")
  //</editor-fold>
  public DataType /*&*/ getValue() {
    return Value;
  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::cl::opt_storage::getValue">
//  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1083,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt_storage::getValue")
//  //</editor-fold>
//  public /*const*/ DataType /*&*/ getValue() /*const*/ {
//    check();
//    return /*Deref*/Location;
//  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt_storage::operator type-parameter-0-0">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1085,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt_storage::operator type-parameter-0-0")
  //</editor-fold>
  public DataType $T() /*const*/ {
    return this.getValue();
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::cl::opt_storage::getDefault">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/Support/CommandLine.h", line = 1087,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/CommandLine.cpp -filter=llvm::cl::opt_storage::getDefault")
  //</editor-fold>
  public /*const*/ OptionValue<DataType> /*&*/ getDefault() /*const*/ {
    return Default;
  }

  @Override
  public String toString() {
    return "opt_storage_impl_internal{" + "isClass=" + isClass + ", Value=[" + Value + "], Default=[" + Default + "]}";
  }
}
