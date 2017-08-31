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
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.ir.*;


/// Base class for constants with no operands.
///
/// These constants have no operands; they represent their data directly.
/// Since they can be in use by unrelated modules (and are never based on
/// GlobalValues), it never makes sense to RAUW them.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantData">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 48,
 FQN="llvm::ConstantData", NM="_ZN4llvm12ConstantDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantDataE")
//</editor-fold>
public class ConstantData extends /*public*/ Constant implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 42,
   FQN="llvm::ConstantData::anchor", NM="_ZN4llvm12ConstantData6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantData6anchorEv")
  //</editor-fold>
  @Override protected/*private*/ void anchor()/* override*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::operator new">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 50,
   FQN="llvm::ConstantData::operator new", NM="_ZN4llvm12ConstantDatanwEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantDatanwEjj")
  //</editor-fold>
  protected/*private*/ static Object/*void P*/ $new_ConstantData(/*size_t*/int $Prm0, /*uint*/int $Prm1) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::ConstantData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 51,
   FQN="llvm::ConstantData::ConstantData", NM="_ZN4llvm12ConstantDataC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantDataC1Ev")
  //</editor-fold>
  protected/*private*/ ConstantData() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::ConstantData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 52,
   FQN="llvm::ConstantData::ConstantData", NM="_ZN4llvm12ConstantDataC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantDataC1ERKS0_")
  //</editor-fold>
  protected/*private*/ ConstantData(final /*const*/ ConstantData /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}


  /*friend  class Constant*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::handleOperandChangeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 55,
   FQN="llvm::ConstantData::handleOperandChangeImpl", NM="_ZN4llvm12ConstantData23handleOperandChangeImplEPNS_5ValueES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantData23handleOperandChangeImplEPNS_5ValueES2_")
  //</editor-fold>
  /*friend*//*package*//*private*/ Value /*P*/ handleOperandChangeImpl(Value /*P*/ From, Value /*P*/ To) {
    throw new llvm_unreachable("Constant data does not have operands!");
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::ConstantData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 60,
   FQN="llvm::ConstantData::ConstantData", NM="_ZN4llvm12ConstantDataC1EPNS_4TypeENS_5Value7ValueTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantDataC1EPNS_4TypeENS_5Value7ValueTyE")
  //</editor-fold>
  protected/*protected*/ /*explicit*/ ConstantData(Type /*P*/ Ty, Value.ValueTy VT) {
    // : Constant(Ty, VT, null, 0)
    //START JInit
    super(Ty, VT, (type$ptr<Use /*P*/> )null, 0);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::operator new">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 61,
   FQN="llvm::ConstantData::operator new", NM="_ZN4llvm12ConstantDatanwEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantDatanwEj")
  //</editor-fold>
  protected static <T extends ConstantData> T/*void P*/ $new_ConstantData(New$ConstructorCallback<T> $Ctor) {
    return User.$new_FixedUses(/*s, */0, $Ctor);
  }

/*public:*/
  /// Methods to support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 65,
   FQN="llvm::ConstantData::classof", NM="_ZN4llvm12ConstantData7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantData7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return $greatereq_uint(V.getValueID(), ValueTy.ConstantDataFirstVal.getValue())
       && $lesseq_uint(V.getValueID(), ValueTy.ConstantDataLastVal.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantData::~ConstantData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 48,
   FQN="llvm::ConstantData::~ConstantData", NM="_ZN4llvm12ConstantDataD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm12ConstantDataD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
