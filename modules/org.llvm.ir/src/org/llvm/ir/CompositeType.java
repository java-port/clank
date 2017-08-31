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
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;
import static org.llvm.ir.java.IrRTTI.*;


/// Common super class of ArrayType, StructType, PointerType and VectorType.
//<editor-fold defaultstate="collapsed" desc="llvm::CompositeType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 156,
 FQN="llvm::CompositeType", NM="_ZN4llvm13CompositeTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm13CompositeTypeE")
//</editor-fold>
public class CompositeType extends /*public*/ Type {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::CompositeType::CompositeType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 158,
   FQN="llvm::CompositeType::CompositeType", NM="_ZN4llvm13CompositeTypeC1ERNS_11LLVMContextENS_4Type6TypeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm13CompositeTypeC1ERNS_11LLVMContextENS_4Type6TypeIDE")
  //</editor-fold>
  protected /*explicit*/ CompositeType(final LLVMContext /*&*/ C, Type.TypeID tid) {
    // : Type(C, tid) 
    //START JInit
    super(C, tid);
    //END JInit
  }

/*public:*/
  /// Given an index value into the type, return the type of the element.
  
  //===----------------------------------------------------------------------===//
  //                       CompositeType Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::CompositeType::getTypeAtIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 554,
   FQN="llvm::CompositeType::getTypeAtIndex", NM="_ZNK4llvm13CompositeType14getTypeAtIndexEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm13CompositeType14getTypeAtIndexEPKNS_5ValueE")
  //</editor-fold>
  public Type /*P*/ getTypeAtIndex(/*const*/ Value /*P*/ V) /*const*/ {
    {
      /*const*/ StructType /*P*/ STy = dyn_cast_StructType(this);
      if ((STy != null)) {
        /*uint*/int Idx = (/*uint*/int)$ulong2uint(cast_Constant(V).getUniqueInteger().getZExtValue());
        assert (indexValid(Idx)) : "Invalid structure index!";
        return STy.getElementType(Idx);
      }
    }
    
    return cast_SequentialType(this).getElementType();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CompositeType::getTypeAtIndex">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 565,
   FQN="llvm::CompositeType::getTypeAtIndex", NM="_ZNK4llvm13CompositeType14getTypeAtIndexEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm13CompositeType14getTypeAtIndexEj")
  //</editor-fold>
  public Type /*P*/ getTypeAtIndex(/*uint*/int Idx) /*const*/ {
    {
      /*const*/ StructType /*P*/ STy = dyn_cast_StructType(this);
      if ((STy != null)) {
        assert (indexValid(Idx)) : "Invalid structure index!";
        return STy.getElementType(Idx);
      }
    }
    
    return cast_SequentialType(this).getElementType();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CompositeType::indexValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 574,
   FQN="llvm::CompositeType::indexValid", NM="_ZNK4llvm13CompositeType10indexValidEPKNS_5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm13CompositeType10indexValidEPKNS_5ValueE")
  //</editor-fold>
  public boolean indexValid(/*const*/ Value /*P*/ V) /*const*/ {
    {
      /*const*/ StructType /*P*/ STy = dyn_cast_StructType(this);
      if ((STy != null)) {
        // Structure indexes require (vectors of) 32-bit integer constants.  In the
        // vector case all of the indices must be equal.
        if (!V.getType().getScalarType().isIntegerTy(32)) {
          return false;
        }
        /*const*/ Constant /*P*/ C = dyn_cast_Constant(V);
        if ((C != null) && V.getType().isVectorTy()) {
          C = C.getSplatValue();
        }
        /*const*/ ConstantInt /*P*/ CU = dyn_cast_or_null_ConstantInt(C);
        return (CU != null) && $less_ulong_uint(CU.getZExtValue(), STy.getNumElements());
      }
    }
    
    // Sequential types can be indexed by any integer.
    return V.getType().isIntOrIntVectorTy();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::CompositeType::indexValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 591,
   FQN="llvm::CompositeType::indexValid", NM="_ZNK4llvm13CompositeType10indexValidEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm13CompositeType10indexValidEj")
  //</editor-fold>
  public boolean indexValid(/*uint*/int Idx) /*const*/ {
    {
      /*const*/ StructType /*P*/ STy = dyn_cast_StructType(this);
      if ((STy != null)) {
        return $less_uint(Idx, STy.getNumElements());
      }
    }
    // Sequential types can be indexed by any integer.
    return true;
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::CompositeType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 168,
   FQN="llvm::CompositeType::classof", NM="_ZN4llvm13CompositeType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm13CompositeType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeID() == TypeID.ArrayTyID
       || T.getTypeID() == TypeID.StructTyID
       || T.getTypeID() == TypeID.PointerTyID
       || T.getTypeID() == TypeID.VectorTyID;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected CompositeType(CompositeType $Prm0) { super($Prm0); /*for descendants*/}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
