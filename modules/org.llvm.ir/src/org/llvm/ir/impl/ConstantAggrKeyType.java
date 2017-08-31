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

package org.llvm.ir.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import static org.llvm.adt.HashingGlobals.*;

//  JAVA: In c++, ConstantAggrKeyType is instantiated thrice 
//  with parameters: ConstantArray, ConstantStruct, and ConstantVector.
//  ConstantInfo.TypeClass (that is used in the declaration of create method) is dypedefed in specializations
//  to ArrayType, StructType, or VectorType accordingly.
//  That's why we need 2-nd template parameter
// Used instantiation to see real code

/*template <class ConstantClass> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 360,
 FQN="llvm::ConstantAggrKeyType", NM="_ZN4llvm19ConstantAggrKeyTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantAggrKeyTypeE")
//</editor-fold>
public class/*struct*/ ConstantAggrKeyType</*class*/ ConstantClass extends ConstantAggregate, TypeClass extends Type>  implements Native.NativeComparable<ConstantAggrKeyType> {
  public ArrayRef<Constant /*P*/ > Operands;
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType::ConstantAggrKeyType<ConstantClass>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 362,
   FQN="llvm::ConstantAggrKeyType::ConstantAggrKeyType<ConstantClass>", NM="_ZN4llvm19ConstantAggrKeyTypeC1ENS_8ArrayRefIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantAggrKeyTypeC1ENS_8ArrayRefIPNS_8ConstantEEE")
  //</editor-fold>
  public ConstantAggrKeyType(ArrayRef<Constant /*P*/ > Operands) {
    // : Operands(Operands) 
    //START JInit
    this.Operands = new ArrayRef<Constant /*P*/ >(Operands);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType::ConstantAggrKeyType<ConstantClass>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 363,
   FQN="llvm::ConstantAggrKeyType::ConstantAggrKeyType<ConstantClass>", NM="_ZN4llvm19ConstantAggrKeyTypeC1ENS_8ArrayRefIPNS_8ConstantEEEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantAggrKeyTypeC1ENS_8ArrayRefIPNS_8ConstantEEEPKT_")
  //</editor-fold>
  public ConstantAggrKeyType(ArrayRef<Constant /*P*/ > Operands, /*const*/ ConstantClass /*P*/ $Prm1) {
    // : Operands(Operands) 
    //START JInit
    this.Operands = new ArrayRef<Constant /*P*/ >(Operands);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType::ConstantAggrKeyType<ConstantClass>">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 365,
   FQN="llvm::ConstantAggrKeyType::ConstantAggrKeyType<ConstantClass>", NM="_ZN4llvm19ConstantAggrKeyTypeC1EPKT_RNS_15SmallVectorImplIPNS_8ConstantEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZN4llvm19ConstantAggrKeyTypeC1EPKT_RNS_15SmallVectorImplIPNS_8ConstantEEE")
  //</editor-fold>
  public ConstantAggrKeyType(/*const*/ ConstantClass /*P*/ C, 
      final SmallVectorImpl<Constant /*P*/ > /*&*/ Storage) {
    // : Operands() 
    //START JInit
    this.Operands = new ArrayRef<Constant /*P*/ >(true);
    //END JInit    
    assert (Storage.empty()) : "Expected empty storage";
    for (/*uint*/int I = 0, E = C.getNumOperands(); I != E; ++I)  {
      Storage.push_back(C.getOperand(I));
    }
    Operands.$assignMove(new ArrayRef<Constant /*P*/ >(Storage, true));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType::operator==">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 373,
   FQN="llvm::ConstantAggrKeyType::operator==", NM="_ZNK4llvm19ConstantAggrKeyTypeeqERKNS_19ConstantAggrKeyTypeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeeqERKNS_19ConstantAggrKeyTypeIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ ConstantAggrKeyType<ConstantClass, TypeClass> /*&*/ X) /*const*/ {
    return Native.$eq(Operands, X.Operands);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType::operator==">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 376,
   FQN="llvm::ConstantAggrKeyType::operator==", NM="_ZNK4llvm19ConstantAggrKeyTypeeqEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeeqEPKT_")
  //</editor-fold>
  public boolean $eq_ConstantClass(/*const*/ ConstantClass /*P*/ C) /*const*/ {
    if (Native.$noteq(Operands.size(), C.getNumOperands())) {
      return false;
    }
    for (/*uint*/int I = 0, E = Operands.size(); I != E; ++I)  {
      if (Native.$noteq(Operands.$at(I), C.getOperand(I))) {
        return false;
      }
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType::getHash">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 384,
   FQN="llvm::ConstantAggrKeyType::getHash", NM="_ZNK4llvm19ConstantAggrKeyType7getHashEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyType7getHashEv")
  //</editor-fold>
  public /*uint*/int getHash() /*const*/ {
    return hash_combine_range_ptrs(Operands.begin(), Operands.end()).$uint();
  }

  
  // JAVA: typedef typename ConstantInfo<ConstantClass>::TypeClass TypeClass
//  public final class TypeClass extends  ConstantInfo.TypeClass<ConstantClass>{ };
//  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType::create">
//  @Converted(kind = Converted.Kind.DELETED,
//   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 389,
//   FQN="llvm::ConstantAggrKeyType::create", NM="_ZNK4llvm19ConstantAggrKeyType6createEPNS_12ConstantInfoIT_E9TypeClassE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyType6createEPNS_12ConstantInfoIT_E9TypeClassE")
//  //</editor-fold>
//  public ConstantClass /*P*/ create( ConstantInfo.TypeClass<ConstantClass> /*P*/ Ty) /*const*/ {
//    return ((/*JCast*/ConstantClass /*P*/ )(/*FIXME: NEW_EXPR [NoNewFun]*/Operands.size() = /*new (Operands.size())*/ new ConstantClass(( Ty, Operands ))));
//  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType<ConstantArray>::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 389,
   FQN="llvm::ConstantAggrKeyType<ConstantArray>::create", NM="_ZNK4llvm19ConstantAggrKeyTypeINS_13ConstantArrayEE6createEPNS_9ArrayTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeINS_13ConstantArrayEE6createEPNS_9ArrayTypeE")
  //</editor-fold>
  public ConstantArray /*P*/ create(ArrayType /*P*/ Ty) /*const*/ {
    return ((/*JCast*/ConstantArray /*P*/ )(/*NEW_EXPR [User::new]*//*Operands.size() = *//*new (Operands.size())*/ User.$new_FixedUses(Operands.size(), (type$ptr<?> New$Mem)->{
        return new ConstantArray(Ty, new ArrayRef<Constant /*P*/ >(Operands));
     })));
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType<ConstantVector>::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 389,
   FQN="llvm::ConstantAggrKeyType<ConstantVector>::create", NM="_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantVectorEE6createEPNS_10VectorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantVectorEE6createEPNS_10VectorTypeE")
  //</editor-fold>
  public ConstantVector /*P*/ create(VectorType /*P*/ Ty) /*const*/ {
    return ((/*JCast*/ConstantVector /*P*/ )(/*NEW_EXPR [User::new]*//*Operands.size() = *//*new (Operands.size())*/ User.$new_FixedUses(Operands.size(), (type$ptr<?> New$Mem)->{
        return new ConstantVector(Ty, new ArrayRef<Constant /*P*/ >(Operands));
     })));
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ConstantAggrKeyType<ConstantStruct>::create">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/ConstantsContext.h", line = 389,
   FQN="llvm::ConstantAggrKeyType<ConstantStruct>::create", NM="_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantStructEE6createEPNS_10StructTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Constants.cpp -nm=_ZNK4llvm19ConstantAggrKeyTypeINS_14ConstantStructEE6createEPNS_10StructTypeE")
  //</editor-fold>
  public ConstantStruct /*P*/ create(StructType /*P*/ Ty) /*const*/ {
    return ((/*JCast*/ConstantStruct /*P*/ )(/*NEW_EXPR [User::new]*//*Operands.size() = *//*new (Operands.size())*/ User.$new_FixedUses(Operands.size(), (type$ptr<?> New$Mem)->{
        return new ConstantStruct(Ty, new ArrayRef<Constant /*P*/ >(Operands));
     })));
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Operands=" + Operands; // NOI18N
  }
}
