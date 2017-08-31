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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.clang.ast.*;
import org.llvm.ir.*;
import org.clang.codegen.impl.*;
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.impl.CGDeclStatics.*;

/// RegularPartialArrayDestroy - a cleanup which performs a partial
/// array destroy where the end pointer is regularly determined and
/// does not need to be loaded from a local.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegularPartialArrayDestroy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1629,
 FQN="(anonymous namespace)::RegularPartialArrayDestroy", NM="_ZN12_GLOBAL__N_126RegularPartialArrayDestroyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_126RegularPartialArrayDestroyE")
//</editor-fold>
public final class RegularPartialArrayDestroy extends /*public*/ EHScopeStack.Cleanup {
  private Value /*P*/ ArrayBegin;
  private Value /*P*/ ArrayEnd;
  private QualType ElementType;
  private CodeGenFunction.AddressQualType2Void Destroyer;
  private CharUnits ElementAlign;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegularPartialArrayDestroy::RegularPartialArrayDestroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1636,
   FQN="(anonymous namespace)::RegularPartialArrayDestroy::RegularPartialArrayDestroy", NM="_ZN12_GLOBAL__N_126RegularPartialArrayDestroyC1EPN4llvm5ValueES3_N5clang8QualTypeENS4_9CharUnitsEPFvRNS4_7CodeGen15CodeGenFunctionENS7_7AddressES5_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_126RegularPartialArrayDestroyC1EPN4llvm5ValueES3_N5clang8QualTypeENS4_9CharUnitsEPFvRNS4_7CodeGen15CodeGenFunctionENS7_7AddressES5_E")
  //</editor-fold>
  public RegularPartialArrayDestroy(Value /*P*/ arrayBegin, Value /*P*/ arrayEnd, 
      QualType elementType, CharUnits elementAlign, 
      CodeGenFunction.AddressQualType2Void destroyer) {
    // : EHScopeStack::Cleanup(), ArrayBegin(arrayBegin), ArrayEnd(arrayEnd), ElementType(elementType), Destroyer(destroyer), ElementAlign(elementAlign) 
    //START JInit
    super();
    this.ArrayBegin = arrayBegin;
    this.ArrayEnd = arrayEnd;
    this.ElementType = new QualType(elementType);
    this.Destroyer = $tryClone(destroyer);
    this.ElementAlign = new CharUnits(elementAlign);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegularPartialArrayDestroy::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1643,
   FQN="(anonymous namespace)::RegularPartialArrayDestroy::Emit", NM="_ZN12_GLOBAL__N_126RegularPartialArrayDestroy4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_126RegularPartialArrayDestroy4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    emitPartialArrayDestroy(CGF, ArrayBegin, ArrayEnd, 
        new QualType(ElementType), new CharUnits(ElementAlign), Destroyer);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegularPartialArrayDestroy::RegularPartialArrayDestroy">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp", line = 1629,
   FQN="(anonymous namespace)::RegularPartialArrayDestroy::RegularPartialArrayDestroy", NM="_ZN12_GLOBAL__N_126RegularPartialArrayDestroyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGDecl.cpp -nm=_ZN12_GLOBAL__N_126RegularPartialArrayDestroyC1EOS0_")
  //</editor-fold>
  public /*inline*/ RegularPartialArrayDestroy(JD$Move _dparam, final RegularPartialArrayDestroy /*&&*/$Prm0) {
    // : EHScopeStack::Cleanup(static_cast<RegularPartialArrayDestroy &&>()), ArrayBegin(static_cast<RegularPartialArrayDestroy &&>().ArrayBegin), ArrayEnd(static_cast<RegularPartialArrayDestroy &&>().ArrayEnd), ElementType(static_cast<RegularPartialArrayDestroy &&>().ElementType), Destroyer(static_cast<RegularPartialArrayDestroy &&>().Destroyer), ElementAlign(static_cast<RegularPartialArrayDestroy &&>().ElementAlign) 
    //START JInit
    super(JD$Move.INSTANCE, $Prm0);
    this.ArrayBegin = $Prm0.ArrayBegin;
    this.ArrayEnd = $Prm0.ArrayEnd;
    this.ElementType = new QualType(JD$Move.INSTANCE, $Prm0.ElementType);
    this.Destroyer = $tryClone($Prm0.Destroyer);
    this.ElementAlign = new CharUnits(JD$Move.INSTANCE, $Prm0.ElementAlign);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "ArrayBegin=" + ArrayBegin // NOI18N
              + ", ArrayEnd=" + ArrayEnd // NOI18N
              + ", ElementType=" + ElementType // NOI18N
              + ", Destroyer=" + Destroyer // NOI18N
              + ", ElementAlign=" + ElementAlign // NOI18N
              + super.toString(); // NOI18N
  }
}
