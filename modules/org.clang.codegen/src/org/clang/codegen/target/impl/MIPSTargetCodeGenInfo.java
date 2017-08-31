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
import static org.clang.codegen.target.impl.TargetInfoStatics.*;
import static org.llvm.ir.java.IrRTTI.cast_Function;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MIPSTargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6154,
 FQN="(anonymous namespace)::MIPSTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_121MIPSTargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_121MIPSTargetCodeGenInfoE")
//</editor-fold>
public class MIPSTargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
  private /*uint*/int SizeOfUnwindException;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MIPSTargetCodeGenInfo::MIPSTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6157,
   FQN="(anonymous namespace)::MIPSTargetCodeGenInfo::MIPSTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_121MIPSTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_121MIPSTargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesEb")
  //</editor-fold>
  public MIPSTargetCodeGenInfo(final CodeGenTypes /*&*/ CGT, boolean IsO32) {
    // : TargetCodeGenInfo(new MipsABIInfo(CGT, IsO32)), SizeOfUnwindException(IsO32 ? 24 : 32) 
    //START JInit
    super(new MipsABIInfo(CGT, IsO32));
    this.SizeOfUnwindException = IsO32 ? 24 : 32;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MIPSTargetCodeGenInfo::getDwarfEHStackPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6161,
   FQN="(anonymous namespace)::MIPSTargetCodeGenInfo::getDwarfEHStackPointer", NM="_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public int getDwarfEHStackPointer(final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    return 29;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MIPSTargetCodeGenInfo::setTargetAttributes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6165,
   FQN="(anonymous namespace)::MIPSTargetCodeGenInfo::setTargetAttributes", NM="_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo19setTargetAttributesEPKN5clang4DeclEPN4llvm11GlobalValueERNS1_7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public void setTargetAttributes(/*const*/ Decl /*P*/ D, GlobalValue /*P*/ GV, 
                     final CodeGenModule /*&*/ CGM) /*const*//* override*/ {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
    if (!(FD != null)) {
      return;
    }
    Function /*P*/ Fn = cast_Function(GV);
    if (FD.hasAttr(Mips16Attr.class)) {
      Fn.addFnAttr(new StringRef(/*KEEP_STR*/"mips16"));
    } else if (FD.hasAttr(NoMips16Attr.class)) {
      Fn.addFnAttr(new StringRef(/*KEEP_STR*/"nomips16"));
    }
    
    /*const*/ MipsInterruptAttr /*P*/ Attr = FD.getAttr(MipsInterruptAttr.class);
    if (!(Attr != null)) {
      return;
    }
    
    /*const*/char$ptr/*char P*/ Kind = create_char$ptr();
    switch (Attr.getInterrupt()) {
     case eic:
      Kind = $tryClone($("eic"));
      break;
     case sw0:
      Kind = $tryClone($("sw0"));
      break;
     case sw1:
      Kind = $tryClone($("sw1"));
      break;
     case hw0:
      Kind = $tryClone($("hw0"));
      break;
     case hw1:
      Kind = $tryClone($("hw1"));
      break;
     case hw2:
      Kind = $tryClone($("hw2"));
      break;
     case hw3:
      Kind = $tryClone($("hw3"));
      break;
     case hw4:
      Kind = $tryClone($("hw4"));
      break;
     case hw5:
      Kind = $tryClone($("hw5"));
      break;
    }
    
    Fn.addFnAttr(new StringRef(/*KEEP_STR*/"interrupt"), new StringRef(Kind));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MIPSTargetCodeGenInfo::initDwarfEHRegSizeTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6487,
   FQN="(anonymous namespace)::MIPSTargetCodeGenInfo::initDwarfEHRegSizeTable", NM="_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  @Override public boolean initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ Address) /*const*//* override*/ {
    // This information comes from gcc's implementation, which seems to
    // as canonical as it gets.
    
    // Everything on MIPS is 4 bytes.  Double-precision FP registers
    // are aliased to pairs of single-precision FP registers.
    Value /*P*/ Four8 = ConstantInt.get(CGF.Int8Ty, $int2ulong(4));
    
    // 0-31 are the general purpose registers, $0 - $31.
    // 32-63 are the floating-point registers, $f0 - $f31.
    // 64 and 65 are the multiply/divide registers, $hi and $lo.
    // 66 is the (notional, I think) register for signal-handler return.
    AssignToArrayRange(CGF.Builder, Address, Four8, 0, 65);
    
    // 67-74 are the floating-point status registers, $fcc0 - $fcc7.
    // They are one bit wide and ignored here.
    
    // 80-111 are the coprocessor 0 registers, $c0r0 - $c0r31.
    // (coprocessor 1 is the FP unit)
    // 112-143 are the coprocessor 2 registers, $c2r0 - $c2r31.
    // 144-175 are the coprocessor 3 registers, $c3r0 - $c3r31.
    // 176-181 are the DSP accumulator registers.
    AssignToArrayRange(CGF.Builder, Address, Four8, 80, 181);
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MIPSTargetCodeGenInfo::getSizeOfUnwindException">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6201,
   FQN="(anonymous namespace)::MIPSTargetCodeGenInfo::getSizeOfUnwindException", NM="_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo24getSizeOfUnwindExceptionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_121MIPSTargetCodeGenInfo24getSizeOfUnwindExceptionEv")
  //</editor-fold>
  @Override public /*uint*/int getSizeOfUnwindException() /*const*//* override*/ {
    return SizeOfUnwindException;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MIPSTargetCodeGenInfo::~MIPSTargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 6154,
   FQN="(anonymous namespace)::MIPSTargetCodeGenInfo::~MIPSTargetCodeGenInfo", NM="_ZN12_GLOBAL__N_121MIPSTargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_121MIPSTargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "SizeOfUnwindException=" + SizeOfUnwindException // NOI18N
              + super.toString(); // NOI18N
  }
}
