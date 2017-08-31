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
import org.clang.codegen.CodeGen.impl.*;
import static org.clang.codegen.impl.ItaniumCXXABIStatics.getEndCatchFn;

/// A cleanup to call __cxa_end_catch.  In many cases, the caught
/// exception type lets us state definitively that the thrown exception
/// type does not have a destructor.  In particular:
///   - Catch-alls tell us nothing, so we have to conservatively
///     assume that the thrown exception might have a destructor.
///   - Catches by reference behave according to their base types.
///   - Catches of non-record types will only trigger for exceptions
///     of non-record types, which never have destructors.
///   - Catches of record types can trigger for arbitrary subclasses
///     of the caught type, so we have to assume the actual thrown
///     exception type might have a throwing destructor, even if the
///     caught type's destructor is trivial or nothrow.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallEndCatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3568,
 FQN="(anonymous namespace)::CallEndCatch", NM="_ZN12_GLOBAL__N_112CallEndCatchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_112CallEndCatchE")
//</editor-fold>
public final class/*struct*/ CallEndCatch extends /**/ EHScopeStack.Cleanup {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallEndCatch::CallEndCatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3569,
   FQN="(anonymous namespace)::CallEndCatch::CallEndCatch", NM="_ZN12_GLOBAL__N_112CallEndCatchC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_112CallEndCatchC1Eb")
  //</editor-fold>
  public CallEndCatch(boolean MightThrow) {
    // : EHScopeStack::Cleanup(), MightThrow(MightThrow) 
    //START JInit
    super();
    this.MightThrow = MightThrow;
    //END JInit
  }

  public boolean MightThrow;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CallEndCatch::Emit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp", line = 3572,
   FQN="(anonymous namespace)::CallEndCatch::Emit", NM="_ZN12_GLOBAL__N_112CallEndCatch4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/ItaniumCXXABI.cpp -nm=_ZN12_GLOBAL__N_112CallEndCatch4EmitERN5clang7CodeGen15CodeGenFunctionENS2_12EHScopeStack7Cleanup5FlagsE")
  //</editor-fold>
  @Override public void Emit(final CodeGenFunction /*&*/ CGF, EHScopeStack.Cleanup.Flags flags)/* override*/ {
    if (!MightThrow) {
      CGF.EmitNounwindRuntimeCall(getEndCatchFn(CGF.CGM));
      return;
    }
    
    CGF.EmitRuntimeCallOrInvoke(getEndCatchFn(CGF.CGM));
  }

  
  @Override public String toString() {
    return "" + "MightThrow=" + MightThrow // NOI18N
              + super.toString(); // NOI18N
  }
}
