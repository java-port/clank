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
import org.llvm.ir.*;
import org.clang.codegen.CodeGen.impl.*;
import org.clang.codegen.target.impl.*;
import static org.clang.codegen.target.impl.TargetInfoStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64TargetCodeGenInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3953,
 FQN="(anonymous namespace)::PPC64TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122PPC64TargetCodeGenInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122PPC64TargetCodeGenInfoE")
//</editor-fold>
public class PPC64TargetCodeGenInfo extends /*public*/ DefaultTargetCodeGenInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64TargetCodeGenInfo::PPC64TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3955,
   FQN="(anonymous namespace)::PPC64TargetCodeGenInfo::PPC64TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122PPC64TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122PPC64TargetCodeGenInfoC1ERN5clang7CodeGen12CodeGenTypesE")
  //</editor-fold>
  public PPC64TargetCodeGenInfo(final CodeGenTypes /*&*/ CGT) {
    // : DefaultTargetCodeGenInfo(CGT) 
    //START JInit
    super(CGT);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64TargetCodeGenInfo::getDwarfEHStackPointer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3957,
   FQN="(anonymous namespace)::PPC64TargetCodeGenInfo::getDwarfEHStackPointer", NM="_ZNK12_GLOBAL__N_122PPC64TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_122PPC64TargetCodeGenInfo22getDwarfEHStackPointerERN5clang7CodeGen13CodeGenModuleE")
  //</editor-fold>
  @Override public int getDwarfEHStackPointer(final CodeGenModule /*&*/ M) /*const*//* override*/ {
    // This is recovered from gcc output.
    return 1; // r1 is the dedicated stack pointer
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64TargetCodeGenInfo::initDwarfEHRegSizeTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 4406,
   FQN="(anonymous namespace)::PPC64TargetCodeGenInfo::initDwarfEHRegSizeTable", NM="_ZNK12_GLOBAL__N_122PPC64TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZNK12_GLOBAL__N_122PPC64TargetCodeGenInfo23initDwarfEHRegSizeTableERN5clang7CodeGen15CodeGenFunctionEPN4llvm5ValueE")
  //</editor-fold>
  @Override public boolean initDwarfEHRegSizeTable(final CodeGenFunction /*&*/ CGF, 
                         Value /*P*/ Address) /*const*//* override*/ {
    
    return PPC64_initDwarfEHRegSizeTable(CGF, Address);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PPC64TargetCodeGenInfo::~PPC64TargetCodeGenInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp", line = 3953,
   FQN="(anonymous namespace)::PPC64TargetCodeGenInfo::~PPC64TargetCodeGenInfo", NM="_ZN12_GLOBAL__N_122PPC64TargetCodeGenInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp -nm=_ZN12_GLOBAL__N_122PPC64TargetCodeGenInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
