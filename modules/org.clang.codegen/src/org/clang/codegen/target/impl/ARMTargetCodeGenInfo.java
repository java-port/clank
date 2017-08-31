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

package org.clang.codegen.target.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.dyn_cast_or_null_FunctionDecl;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import static org.clang.codegen.java.CodegenRTTI.cast_ARMABIInfo;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;
import static org.llvm.ir.java.IrRTTI.cast_Function;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5015,
 FQN="(anonymous namespace)::ARMTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_120ARMTargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_120ARMTargetCodeGenInfoE")
//</editor-fold>
public class ARMTargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::ARMTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5017,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::ARMTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_120ARMTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesENS_10ARMABIInfo7ABIKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_120ARMTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesENS_10ARMABIInfo7ABIKindE")
  //</editor-fold>
  public ARMTargetCodeGenInfo(final CodeGenTypes /*&*/ CGT, ARMABIInfo.ABIKind K) {
    // : TargetCodeGenInfo(new ARMABIInfo(CGT, K)) 
    //START JInit
    super(new ARMABIInfo(CGT, K));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::getABIInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5020,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::getABIInfo", NM="_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo10getABIInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo10getABIInfoEv")
  //</editor-fold>
  public /*const*/ ARMABIInfo /*&*/ getABIInfo() /*const*/ {
    return ((/*static_cast*//*const*/ ARMABIInfo /*&*/ )(super.getABIInfo()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::getDwarfEHStackPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5024,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::getDwarfEHStackPointer", NM="_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public int getDwarfEHStackPointer(final CodeGenModule /*&*/ M) /*const*//* override*/ {
    return 13;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::getARCRetainAutoreleasedReturnValueMarker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5028,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::getARCRetainAutoreleasedReturnValueMarker", NM="_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo41getARCRetainAutoreleasedReturnValueMarkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo41getARCRetainAutoreleasedReturnValueMarkerEv")
  //</editor-fold>
  @Override public StringRef getARCRetainAutoreleasedReturnValueMarker() /*const*//* override*/ {
    return new StringRef(/*KEEP_STR*/"mov\tr7, r7\t\t@ marker for objc_retainAutoreleaseReturnValue");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::initDwarfEHRegSizeTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5032,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::initDwarfEHRegSizeTable", NM="_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  @Override public boolean initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ Address) /*const*//* override*/ {
    Value /*P*/ Four8 = ConstantInt.get(CGF.Int8Ty, $int2ulong(4));
    
    // 0-15 are the 16 integer registers.
    AssignToArrayRange(CGF.Builder, Address, Four8, 0, 15);
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::getSizeOfUnwindException">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5041,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::getSizeOfUnwindException", NM="_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo24getSizeOfUnwindExceptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo24getSizeOfUnwindExceptionEv")
  //</editor-fold>
  @Override public /*uint*/int getSizeOfUnwindException() /*const*//* override*/ {
    if (getABIInfo().isEABI()) {
      return 88;
    }
    return super.getSizeOfUnwindException();
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::setTargetAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5046,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::setTargetAttributes", NM="_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_120ARMTargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void setTargetAttributes(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
                     final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    AttrBuilder B = null;
    try {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
      if (!(FD != null)) {
        return;
      }
      
      /*const*/ ARMInterruptAttr /*P*/ Attr = FD.getAttr(ARMInterruptAttr.class);
      if (!(Attr != null)) {
        return;
      }
      
      /*const*/char$ptr/*char P*/ Kind = create_char$ptr();
      switch (Attr.getInterrupt()) {
       case Generic:
        Kind = $tryClone($EMPTY);
        break;
       case IRQ:
        Kind = $tryClone($("IRQ"));
        break;
       case FIQ:
        Kind = $tryClone($("FIQ"));
        break;
       case SWI:
        Kind = $tryClone($("SWI"));
        break;
       case ABORT:
        Kind = $tryClone($("ABORT"));
        break;
       case UNDEF:
        Kind = $tryClone($("UNDEF"));
        break;
      }
      
      Function /*P*/ Fn = cast_Function(GV);
      
      Fn.addFnAttr(new StringRef(/*KEEP_STR*/"interrupt"), new StringRef(Kind));
      
      ARMABIInfo.ABIKind ABI = cast_ARMABIInfo(getABIInfo()).getABIKind();
      if (ABI == ARMABIInfo.ABIKind.APCS) {
        return;
      }
      
      // AAPCS guarantees that sp will be 8-byte aligned on any public interface,
      // however this is not necessarily true on taking any interrupt. Instruct
      // the backend to perform a realignment as part of the function prologue.
      B/*J*/= new AttrBuilder();
      B.addStackAlignmentAttr(8);
      Fn.addAttributes(AttributeSet.AttrIndex.FunctionIndex.getValue(), 
          AttributeSet.get(CGM.getLLVMContext(), 
              AttributeSet.AttrIndex.FunctionIndex.getValue(), 
              B));
    } finally {
      if (B != null) { B.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetCodeGenInfo::~ARMTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 5015,
   FQN="(anonymous namespace)::ARMTargetCodeGenInfo::~ARMTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_120ARMTargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_120ARMTargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
