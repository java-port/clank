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
import static org.clank.support.Unsigned.*;
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.CodeGen.target.impl.*;
import org.clang.codegen.target.impl.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32TargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3643,
 FQN="(anonymous namespace)::PPC32TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122PPC32TargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122PPC32TargetCodeGenInfoE")
//</editor-fold>
public class PPC32TargetCodeGenInfo extends /*public*/ TargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32TargetCodeGenInfo::PPC32TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3645,
   FQN="(anonymous namespace)::PPC32TargetCodeGenInfo::PPC32TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122PPC32TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122PPC32TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesEb")
  //</editor-fold>
  public PPC32TargetCodeGenInfo(final CodeGenTypes /*&*/ CGT, boolean SoftFloatABI) {
    // : TargetCodeGenInfo(new PPC32_SVR4_ABIInfo(CGT, SoftFloatABI)) 
    //START JInit
    super(new PPC32_SVR4_ABIInfo(CGT, SoftFloatABI));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32TargetCodeGenInfo::getDwarfEHStackPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3648,
   FQN="(anonymous namespace)::PPC32TargetCodeGenInfo::getDwarfEHStackPointer", NM="_ZNK12_GLOBAL__N_122PPC32TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_122PPC32TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public int getDwarfEHStackPointer(final CodeGenModule /*&*/ M) /*const*//* override*/ {
    // This is recovered from gcc output.
    return 1; // r1 is the dedicated stack pointer
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32TargetCodeGenInfo::initDwarfEHRegSizeTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3806,
   FQN="(anonymous namespace)::PPC32TargetCodeGenInfo::initDwarfEHRegSizeTable", NM="_ZNK12_GLOBAL__N_122PPC32TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_122PPC32TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  @Override public boolean initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ Address) /*const*//* override*/ {
    // This is calculated from the LLVM and GCC tables and verified
    // against gcc output.  AFAIK all ABIs use the same encoding.
    final CGBuilderTy /*&*/ Builder = CGF.Builder;
    
    IntegerType /*P*/ i8 = CGF.Int8Ty;
    Value /*P*/ Four8 = ConstantInt.get(i8, $int2ulong(4));
    Value /*P*/ Eight8 = ConstantInt.get(i8, $int2ulong(8));
    Value /*P*/ Sixteen8 = ConstantInt.get(i8, $int2ulong(16));
    
    // 0-31: r0-31, the 4-byte general-purpose registers
    AssignToArrayRange(Builder, Address, Four8, 0, 31);
    
    // 32-63: fp0-31, the 8-byte floating-point registers
    AssignToArrayRange(Builder, Address, Eight8, 32, 63);
    
    // 64-76 are various 4-byte special-purpose registers:
    // 64: mq
    // 65: lr
    // 66: ctr
    // 67: ap
    // 68-75 cr0-7
    // 76: xer
    AssignToArrayRange(Builder, Address, Four8, 64, 76);
    
    // 77-108: v0-31, the 16-byte vector registers
    AssignToArrayRange(Builder, Address, Sixteen8, 77, 108);
    
    // 109: vrsave
    // 110: vscr
    // 111: spe_acc
    // 112: spefscr
    // 113: sfp
    AssignToArrayRange(Builder, Address, Four8, 109, 113);
    
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC32TargetCodeGenInfo::~PPC32TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3643,
   FQN="(anonymous namespace)::PPC32TargetCodeGenInfo::~PPC32TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122PPC32TargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122PPC32TargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
