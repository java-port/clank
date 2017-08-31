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
import static org.clank.support.Casts.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.impl.*;


/// Class to represent function types
///
//<editor-fold defaultstate="collapsed" desc="llvm::FunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 99,
 FQN="llvm::FunctionType", NM="_ZN4llvm12FunctionTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionTypeE")
//</editor-fold>
public class FunctionType extends /*public*/ Type {
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::FunctionType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 100,
   FQN="llvm::FunctionType::FunctionType", NM="_ZN4llvm12FunctionTypeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionTypeC1ERKS0_")
  //</editor-fold>
  protected/*private*/ FunctionType(final /*const*/ FunctionType /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 101,
   FQN="llvm::FunctionType::operator=", NM="_ZN4llvm12FunctionTypeaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionTypeaSERKS0_")
  //</editor-fold>
  protected/*private*/ /*const*/ FunctionType /*&*/ $assign(final /*const*/ FunctionType /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  //===----------------------------------------------------------------------===//
  //                       FunctionType Implementation
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::FunctionType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 271,
   FQN="llvm::FunctionType::FunctionType", NM="_ZN4llvm12FunctionTypeC1EPNS_4TypeENS_8ArrayRefIS2_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionTypeC1EPNS_4TypeENS_8ArrayRefIS2_EEb")
  //</editor-fold>
  private FunctionType(type$ptr<?> this$plus1, Type /*P*/ Result, ArrayRef<Type /*P*/ > Params, 
      boolean IsVarArgs) {
    // : Type(Result->getContext(), FunctionTyID) 
    //START JInit
    super(Result.getContext(), TypeID.FunctionTyID);
    //END JInit
    type$ptr<Type /*P*/ /*P*/> SubTys = $tryClone(((type$ptr<Type /*P*/ /*P*/>)reinterpret_cast(type$ptr.class, this$plus1)));
    assert (FunctionType.isValidReturnType(Result)) : "invalid return type for function";
    setSubclassData((IsVarArgs ? 1 : 0));
    
    SubTys.$set(0, Result);
    
    for (/*uint*/int i = 0, e = Params.size(); i != e; ++i) {
      assert (FunctionType.isValidArgumentType(Params.$at(i))) : "Not a valid type for function argument!";
      SubTys.$set(i + 1, Params.$at(i));
    }
    
    ContainedTys = $tryClone(SubTys);
    NumContainedTys = Params.size() + 1; // + 1 for result type
  }

/*public:*/
  /// This static method is the primary way of constructing a FunctionType.
  
  // This is the factory function for the FunctionType class.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::get">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*ALLOC*/,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 291,
   FQN="llvm::FunctionType::get", NM="_ZN4llvm12FunctionType3getEPNS_4TypeENS_8ArrayRefIS2_EEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionType3getEPNS_4TypeENS_8ArrayRefIS2_EEb")
  //</editor-fold>
  public static FunctionType /*P*/ get(Type /*P*/ ReturnType, 
     ArrayRef<Type /*P*/ > Params, boolean isVarArg) {
    LLVMContextImpl /*P*/ pImpl = ReturnType.getContext().pImpl;
    FunctionTypeKeyInfo.KeyTy Key/*J*/= new FunctionTypeKeyInfo.KeyTy(ReturnType, Params, isVarArg);
    DenseSet.iterator<FunctionType /*P*/> I = pImpl.FunctionTypes.find_as_T$C$R(Key);
    FunctionType /*P*/ FT;
    if (I.$eq(pImpl.FunctionTypes.end())) {
      // JAVA: ALLOC
      type$ptr $Mem = pImpl.TypeAllocator.
          Allocate$JavaRef((true? 1: $sizeof_FunctionType()) + (true ? 1 : $sizeof_ptr(/*Type  */)) * (Params.size() + 1)/*, 
          AlignOf.<FunctionType>Alignment*/);
      /*NEW_EXPR [System]*/FT = /*new (FT)*/ $new_uint_voidPtr($Mem, (type$ptr<?> New$Mem)->{
          return new FunctionType(New$Mem.$add(1), ReturnType, new ArrayRef<Type /*P*/ >(Params), isVarArg);
       });
      $Mem.$set(0, FT);
      pImpl.FunctionTypes.insert(FT);
    } else {
      FT = I.$star();
    }
    
    return FT;
  }

  
  /// Create a FunctionType taking no parameters.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::get">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 311,
   FQN="llvm::FunctionType::get", NM="_ZN4llvm12FunctionType3getEPNS_4TypeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionType3getEPNS_4TypeEb")
  //</editor-fold>
  public static FunctionType /*P*/ get(Type /*P*/ Result, boolean isVarArg) {
    return get(Result, new ArrayRef<Type /*P*/ >(None, true), isVarArg);
  }

  
  /// Return true if the specified type is valid as a return type.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::isValidReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 315,
   FQN="llvm::FunctionType::isValidReturnType", NM="_ZN4llvm12FunctionType17isValidReturnTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionType17isValidReturnTypeEPNS_4TypeE")
  //</editor-fold>
  public static boolean isValidReturnType(Type /*P*/ RetTy) {
    return !RetTy.isFunctionTy() && !RetTy.isLabelTy()
       && !RetTy.isMetadataTy();
  }

  
  /// Return true if the specified type is valid as an argument type.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::isValidArgumentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/IR/Type.cpp", line = 320,
   FQN="llvm::FunctionType::isValidArgumentType", NM="_ZN4llvm12FunctionType19isValidArgumentTypeEPNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionType19isValidArgumentTypeEPNS_4TypeE")
  //</editor-fold>
  public static boolean isValidArgumentType(Type /*P*/ ArgTy) {
    return ArgTy.isFirstClassType();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::isVarArg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 118,
   FQN="llvm::FunctionType::isVarArg", NM="_ZNK4llvm12FunctionType8isVarArgEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm12FunctionType8isVarArgEv")
  //</editor-fold>
  public boolean isVarArg() /*const*/ {
    return getSubclassData() != 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::getReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 119,
   FQN="llvm::FunctionType::getReturnType", NM="_ZNK4llvm12FunctionType13getReturnTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm12FunctionType13getReturnTypeEv")
  //</editor-fold>
  public Type /*P*/ getReturnType() /*const*/ {
    return ContainedTys.$at(0);
  }

  
  // JAVA: typedef Type::subtype_iterator param_iterator
//  public final class param_iterator extends type$ptr<Type /*P*/ /*const*/ /*P*/>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::param_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 122,
   FQN="llvm::FunctionType::param_begin", NM="_ZNK4llvm12FunctionType11param_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm12FunctionType11param_beginEv")
  //</editor-fold>
  public type$ptr<Type /*P*/> param_begin() /*const*/ {
    return ContainedTys.$add(1);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::param_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 123,
   FQN="llvm::FunctionType::param_end", NM="_ZNK4llvm12FunctionType9param_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm12FunctionType9param_endEv")
  //</editor-fold>
  public type$ptr<Type /*P*/> param_end() /*const*/ {
    return ContainedTys.$add(NumContainedTys);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::params">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 124,
   FQN="llvm::FunctionType::params", NM="_ZNK4llvm12FunctionType6paramsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm12FunctionType6paramsEv")
  //</editor-fold>
  public ArrayRef<Type /*P*/ > params() /*const*/ {
    return makeArrayRef(param_begin(), param_end());
  }

  
  /// Parameter type accessors.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::getParamType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 129,
   FQN="llvm::FunctionType::getParamType", NM="_ZNK4llvm12FunctionType12getParamTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm12FunctionType12getParamTypeEj")
  //</editor-fold>
  public Type /*P*/ getParamType(/*uint*/int i) /*const*/ {
    return ContainedTys.$at(i + 1);
  }

  
  /// Return the number of fixed parameters this function type requires.
  /// This does not consider varargs.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::getNumParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 133,
   FQN="llvm::FunctionType::getNumParams", NM="_ZNK4llvm12FunctionType12getNumParamsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZNK4llvm12FunctionType12getNumParamsEv")
  //</editor-fold>
  public /*uint*/int getNumParams() /*const*/ {
    return NumContainedTys - 1;
  }

  
  /// Methods for support type inquiry through isa, cast, and dyn_cast.
  //<editor-fold defaultstate="collapsed" desc="llvm::FunctionType::classof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/DerivedTypes.h", line = 136,
   FQN="llvm::FunctionType::classof", NM="_ZN4llvm12FunctionType7classofEPKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Type.cpp -nm=_ZN4llvm12FunctionType7classofEPKNS_4TypeE")
  //</editor-fold>
  public static /*inline*/ boolean classof(/*const*/ Type /*P*/ T) {
    return T.getTypeID() == TypeID.FunctionTyID;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static int $sizeof_FunctionType() {
    throw new UnsupportedOperationException();
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
