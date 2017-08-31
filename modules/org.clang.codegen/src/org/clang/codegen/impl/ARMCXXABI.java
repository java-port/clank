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

package org.clang.codegen.impl;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import org.llvm.ir.Type;
import static org.clang.ast.java.AstDeclarationsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 401,
 FQN="(anonymous namespace)::ARMCXXABI", NM="_ZN12_GLOBAL__N_19ARMCXXABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_19ARMCXXABIE")
//</editor-fold>
public class ARMCXXABI extends /*public*/ ItaniumCXXABI implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI::ARMCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 403,
   FQN="(anonymous namespace)::ARMCXXABI::ARMCXXABI", NM="_ZN12_GLOBAL__N_19ARMCXXABIC1ERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_19ARMCXXABIC1ERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  public ARMCXXABI(final CodeGenModule /*&*/ CGM) {
    // : ItaniumCXXABI(CGM, /* UseARMMethodPtrABI = */ true, /* UseARMGuardVarABI = */ true) 
    //START JInit
    super(CGM, true, 
        true);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI::HasThisReturn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 407,
   FQN="(anonymous namespace)::ARMCXXABI::HasThisReturn", NM="_ZNK12_GLOBAL__N_19ARMCXXABI13HasThisReturnEN5clang10GlobalDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZNK12_GLOBAL__N_19ARMCXXABI13HasThisReturnEN5clang10GlobalDeclE")
  //</editor-fold>
  @Override public boolean HasThisReturn(GlobalDecl GD) /*const*//* override*/ {
    return (isa_CXXConstructorDecl(GD.getDecl()) || (isa_CXXDestructorDecl(GD.getDecl())
       && GD.getDtorType() != CXXDtorType.Dtor_Deleting));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI::EmitReturnFromThunk">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1716,
   FQN="(anonymous namespace)::ARMCXXABI::EmitReturnFromThunk", NM="_ZN12_GLOBAL__N_19ARMCXXABI19EmitReturnFromThunkERN5clang7CodeGen15CodeGenFunctionENS2_6RValueENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_19ARMCXXABI19EmitReturnFromThunkERN5clang7CodeGen15CodeGenFunctionENS2_6RValueENS1_8QualTypeE")
  //</editor-fold>
  @Override public void EmitReturnFromThunk(final CodeGenFunction /*&*/ CGF, 
                     RValue RV, QualType ResultType)/* override*/ {
    if (!isa_CXXDestructorDecl(CGF.CurGD.getDecl())) {
      super.EmitReturnFromThunk(CGF, new RValue(RV), new QualType(ResultType));
      /*JAVA:return*/return;
    }
    
    // Destructor thunks in the ARM ABI have indeterminate results.
    Type /*P*/ T = CGF.ReturnValue.getElementType();
    RValue Undef = RValue.get(UndefValue.get(T));
    super.EmitReturnFromThunk(CGF, new RValue(Undef), new QualType(ResultType));
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI::getArrayCookieSizeImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1807,
   FQN="(anonymous namespace)::ARMCXXABI::getArrayCookieSizeImpl", NM="_ZN12_GLOBAL__N_19ARMCXXABI22getArrayCookieSizeImplEN5clang8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_19ARMCXXABI22getArrayCookieSizeImplEN5clang8QualTypeE")
  //</editor-fold>
  @Override public CharUnits getArrayCookieSizeImpl(QualType elementType)/* override*/ {
    // ARM says that the cookie is always:
    //   struct array_cookie {
    //     std::size_t element_size; // element_size != 0
    //     std::size_t element_count;
    //   };
    // But the base ABI doesn't give anything an alignment greater than
    // 8, so we can dismiss this as typical ABI-author blindness to
    // actual language complexity and round up to the element alignment.
    return new CharUnits(std.max(CharUnits.fromQuantity(2 * $uchar2int(CGM.Unnamed_field13.SizeSizeInBytes)), 
            CGM.getContext().getTypeAlignInChars(new QualType(elementType))));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI::InitializeArrayCookie">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1820,
   FQN="(anonymous namespace)::ARMCXXABI::InitializeArrayCookie", NM="_ZN12_GLOBAL__N_19ARMCXXABI21InitializeArrayCookieERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueEPKNS1_10CXXNewExprENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_19ARMCXXABI21InitializeArrayCookieERN5clang7CodeGen15CodeGenFunctionENS2_7AddressEPN4llvm5ValueEPKNS1_10CXXNewExprENS1_8QualTypeE")
  //</editor-fold>
  @Override public Address InitializeArrayCookie(final CodeGenFunction /*&*/ CGF, 
                       Address newPtr, 
                       Value /*P*/ numElements, 
                       /*const*/ CXXNewExpr /*P*/ expr, 
                       QualType elementType)/* override*/ {
    assert (requiresArrayCookie(expr));
    
    // The cookie is always at the start of the buffer.
    Address cookie = new Address(newPtr);
    
    // The first element is the element size.
    cookie.$assignMove(CGF.Builder.CreateElementBitCast(new Address(cookie), CGF.Unnamed_field8.SizeTy));
    Value /*P*/ elementSize = ConstantInt.get(CGF.Unnamed_field8.SizeTy, 
        getContext().getTypeSizeInChars(/*NO_COPY*/elementType).getQuantity());
    CGF.Builder.CreateStore(elementSize, new Address(cookie));
    
    // The second element is the element count.
    cookie.$assignMove(CGF.Builder.CreateConstInBoundsGEP(new Address(cookie), $int2ulong(1), CGF.getSizeSize()));
    CGF.Builder.CreateStore(numElements, new Address(cookie));
    
    // Finally, compute a pointer to the actual data buffer by skipping
    // over the cookie completely.
    CharUnits cookieSize = super.getArrayCookieSizeImpl(new QualType(elementType));
    return CGF.Builder.CreateConstInBoundsByteGEP(new Address(newPtr), new CharUnits(cookieSize));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI::readArrayCookieImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 1846,
   FQN="(anonymous namespace)::ARMCXXABI::readArrayCookieImpl", NM="_ZN12_GLOBAL__N_19ARMCXXABI19readArrayCookieImplERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_9CharUnitsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_19ARMCXXABI19readArrayCookieImplERN5clang7CodeGen15CodeGenFunctionENS2_7AddressENS1_9CharUnitsE")
  //</editor-fold>
  @Override public Value /*P*/ readArrayCookieImpl(final CodeGenFunction /*&*/ CGF, 
                     Address allocPtr, 
                     CharUnits cookieSize)/* override*/ {
    // The number of elements is at offset sizeof(size_t) relative to
    // the allocated pointer.
    Address numElementsPtr = CGF.Builder.CreateConstInBoundsByteGEP(new Address(allocPtr), CGF.getSizeSize());
    
    numElementsPtr.$assignMove(CGF.Builder.CreateElementBitCast(new Address(numElementsPtr), CGF.Unnamed_field8.SizeTy));
    return CGF.Builder.CreateLoad(new Address(numElementsPtr));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMCXXABI::~ARMCXXABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 401,
   FQN="(anonymous namespace)::ARMCXXABI::~ARMCXXABI", NM="_ZN12_GLOBAL__N_19ARMCXXABID0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_19ARMCXXABID0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
