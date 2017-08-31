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
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


//===----------------------------------------------------------------------===//
/// 'undef' values are things that do not have specified contents.
/// These are used for a variety of purposes, including global variable
/// initializers and operands to instructions.  'undef' values can occur with
/// any first-class type.
///
/// Undef values aren't exactly constants; if they have multiple uses, they
/// can appear to have different bit patterns at each use. See
/// LangRef.html#undefvalues for details.
///
//<editor-fold defaultstate="collapsed" desc="llvm::UndefValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1203,
 FQN="llvm::UndefValue", NM="_ZN4llvm10UndefValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10UndefValueE")
//</editor-fold>
public final class UndefValue extends /*public*/ ConstantData implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::UndefValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1204,
   FQN="llvm::UndefValue::UndefValue", NM="_ZN4llvm10UndefValueC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10UndefValueC1ERKS0_")
  //</editor-fold>
  protected/*private*/ UndefValue(final /*const*/ UndefValue /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}


  /*friend  class Constant*/

  /// Remove the constant from the constant table.
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::destroyConstantImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1351,
   FQN="llvm::UndefValue::destroyConstantImpl", NM="_ZN4llvm10UndefValue19destroyConstantImplEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10UndefValue19destroyConstantImplEv")
  //</editor-fold>
  /*friend*//*package*//*private*/ void destroyConstantImpl() {
    // Free the constant and any dangling references to it.
    getContext().pImpl.UVConstants.erase(getType());
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::UndefValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1209,
   FQN="llvm::UndefValue::UndefValue", NM="_ZN4llvm10UndefValueC1EPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10UndefValueC1EPNS_4TypeE")
  //</editor-fold>
  private /*explicit*/ UndefValue(Type /*P*/ T) {
    // : ConstantData(T, UndefValueVal)
    //START JInit
    super(T, ValueTy.UndefValueVal);
    //END JInit
  }

/*public:*/
  /// Static factory methods - Return an 'undef' object of the specified type.
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::get">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 1342,
   FQN="llvm::UndefValue::get", NM="_ZN4llvm10UndefValue3getEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10UndefValue3getEPNS_4TypeE")
  //</editor-fold>
  public static UndefValue /*P*/ get(Type /*P*/ Ty) {
    final type$ref<UndefValue /*P*/ /*&*/> Entry = Ty.getContext().pImpl.UVConstants.ref$at(Ty);
    if (!(Entry.$deref() != null)) {
      Entry.$set(/*NEW_EXPR [ConstantData::new]*/ConstantData.$new_ConstantData((type$ptr<?> New$Mem)->{
          return new UndefValue(Ty);
       }));
    }

    return Entry.$deref();
  }


  /// If this Undef has array or vector type, return a undef with the right
  /// element type.

  //===----------------------------------------------------------------------===//
  //                         UndefValue Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::getSequentialElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 777,
   FQN="llvm::UndefValue::getSequentialElement", NM="_ZNK4llvm10UndefValue20getSequentialElementEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10UndefValue20getSequentialElementEv")
  //</editor-fold>
  public UndefValue /*P*/ getSequentialElement() /*const*/ {
    return UndefValue.get(getType().getSequentialElementType());
  }


  /// If this undef has struct type, return a undef with the right element type
  /// for the specified element.
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::getStructElement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 781,
   FQN="llvm::UndefValue::getStructElement", NM="_ZNK4llvm10UndefValue16getStructElementEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10UndefValue16getStructElementEj")
  //</editor-fold>
  public UndefValue /*P*/ getStructElement(/*uint*/int Elt) /*const*/ {
    return UndefValue.get(getType().getStructElementType(Elt));
  }


  /// Return an undef of the right value for the specified GEP index if we can,
  /// otherwise return null (e.g. if C is a ConstantExpr).
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::getElementValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 785,
   FQN="llvm::UndefValue::getElementValue", NM="_ZNK4llvm10UndefValue15getElementValueEPNS_8ConstantE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10UndefValue15getElementValueEPNS_8ConstantE")
  //</editor-fold>
  public UndefValue /*P*/ getElementValue(Constant /*P*/ C) /*const*/ {
    if (isa_SequentialType(getType())) {
      return getSequentialElement();
    }
    return getStructElement($ulong2uint(cast_ConstantInt(C).getZExtValue()));
  }


  /// Return an undef of the right value for the specified GEP index.
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::getElementValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 791,
   FQN="llvm::UndefValue::getElementValue", NM="_ZNK4llvm10UndefValue15getElementValueEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10UndefValue15getElementValueEj")
  //</editor-fold>
  public UndefValue /*P*/ getElementValue(/*uint*/int Idx) /*const*/ {
    if (isa_SequentialType(getType())) {
      return getSequentialElement();
    }
    return getStructElement(Idx);
  }


  /// Return the number of elements in the array, vector, or struct.
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::getNumElements">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Constants.cpp", line = 797,
   FQN="llvm::UndefValue::getNumElements", NM="_ZNK4llvm10UndefValue14getNumElementsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm10UndefValue14getNumElementsEv")
  //</editor-fold>
  public /*uint*/int getNumElements() /*const*/ {
    Type /*P*/ Ty = getType();
    {
      ArrayType /*P*/ AT = dyn_cast_ArrayType(Ty);
      if ((AT != null)) {
        return $ulong2uint(AT.getNumElements());
      }
    }
    {
      VectorType /*P*/ VT = dyn_cast_VectorType(Ty);
      if ((VT != null)) {
        return VT.getNumElements();
      }
    }
    return Ty.getStructNumElements();
  }


  /// Methods for support type inquiry through isa, cast, and dyn_cast:
  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1234,
   FQN="llvm::UndefValue::classof", NM="_ZN4llvm10UndefValue7classofEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10UndefValue7classofEPKNS_5ValueE")
  //</editor-fold>
  public static boolean classof(/*const*/ Value /*P*/ V) {
    return V.getValueID() == ValueTy.UndefValueVal.getValue();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::UndefValue::~UndefValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/Constants.h", line = 1203,
   FQN="llvm::UndefValue::~UndefValue", NM="_ZN4llvm10UndefValueD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm10UndefValueD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
