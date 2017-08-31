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

package org.llvm.ir;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// A constant pointer value that points to null
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 508,
 FQN="llvm::ConstantPointerNull", NM="_ZN4llvm19ConstantPointerNullE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantPointerNullE")
//</editor-fold>
public final class ConstantPointerNull extends /*public*/ ConstantData implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull::ConstantPointerNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 509,
   FQN="llvm::ConstantPointerNull::ConstantPointerNull", NM="_ZN4llvm19ConstantPointerNullC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantPointerNullC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ConstantPointerNull(final /*const*/ ConstantPointerNull /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}


  /*friend  class Constant*/

  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1338,
   FQN="llvm::ConstantPointerNull::destroyConstantImpl", NM="_ZN4llvm19ConstantPointerNull19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantPointerNull19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*//*private*/ void destroyConstantImpl() {
    getContext().pImpl.CPNConstants.erase(getType());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull::ConstantPointerNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 514,
   FQN="llvm::ConstantPointerNull::ConstantPointerNull", NM="_ZN4llvm19ConstantPointerNullC1EPNS_11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantPointerNullC1EPNS_11PointerTypeE")
  //</editor-fold>
  private /*explicit*/ ConstantPointerNull(PointerType /*P*/ T) {
    // : ConstantData(T, Value::ConstantPointerNullVal)
    //START JInit
    super(T, Value.ValueTy.ConstantPointerNullVal);
    //END JInit
  }

/*public:*/
  /// Static factory methods - Return objects of the specified value

  //---- ConstantPointerNull::get() implementation.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1329,
   FQN="llvm::ConstantPointerNull::get", NM="_ZN4llvm19ConstantPointerNull3getEPNS_11PointerTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantPointerNull3getEPNS_11PointerTypeE")
  //</editor-fold>
  public static ConstantPointerNull /*P*/ get(PointerType /*P*/ Ty) {
    final type$ref<ConstantPointerNull /*P*/ /*&*/> Entry = Ty.getContext().pImpl.CPNConstants.ref$at(Ty);
    if (!(Entry.$deref() != null)) {
      Entry.$set(/*NEW_EXPR [ConstantData::new]*/ConstantData.$new_ConstantData((type$ptr<?> New$Mem)->{
          return new ConstantPointerNull(Ty);
       }));
    }

    return Entry.$deref();
  }


  /// Specialize the getType() method to always return an PointerType,
  /// which reduces the amount of casting needed in parts of the compiler.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull::getType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 523,
   FQN="llvm::ConstantPointerNull::getType", NM="_ZNK4llvm19ConstantPointerNull7getTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantPointerNull7getTypeEv")
  //</editor-fold>
  public /*inline*/ PointerType /*P*/ getType() /*const*/ {
    return cast_PointerType(super.getType());
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 528,
   FQN="llvm::ConstantPointerNull::classof", NM="_ZN4llvm19ConstantPointerNull7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantPointerNull7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.ConstantPointerNullVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantPointerNull::~ConstantPointerNull">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 508,
   FQN="llvm::ConstantPointerNull::~ConstantPointerNull", NM="_ZN4llvm19ConstantPointerNullD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantPointerNullD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
