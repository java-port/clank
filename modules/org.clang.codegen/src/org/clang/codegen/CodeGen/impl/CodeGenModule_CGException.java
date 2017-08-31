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
package org.clang.codegen.CodeGen.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.llvm.ir.*;
import org.llvm.ir.FunctionType;
import static org.clang.codegen.impl.CGExceptionStatics.*;
import static org.clank.support.Native.$AddrOf;


//<editor-fold defaultstate="collapsed" desc="static type CodeGenModule_CGException">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.codegen.CodeGen.impl.CodeGenModule_CGException",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this -extends=CodeGenModule_CGDeclCXX ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getTerminateFnEv;_ZN5clang7CodeGen13CodeGenModule19SimplifyPersonalityEv; -static-type=CodeGenModule_CGException -package=org.clang.codegen.CodeGen.impl")
//</editor-fold>
public abstract class CodeGenModule_CGException extends CodeGenModule_CGDeclCXX {
private final /*split clang::CodeGen::CodeGenModule*/ CodeGenModule $this() { return (CodeGenModule)this; }


/// \breif Get the declaration of std::terminate for the platform.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::getTerminateFn">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 50,
 FQN="clang::CodeGen::CodeGenModule::getTerminateFn", NM="_ZN5clang7CodeGen13CodeGenModule14getTerminateFnEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CodeGenModule14getTerminateFnEv")
//</editor-fold>
public final Constant /*P*/ getTerminateFn() {
  // void __terminate();
  FunctionType /*P*/ FTy = FunctionType.get($this().VoidTy, /*IsVarArgs=*/ false);
  
  StringRef name/*J*/= new StringRef();
  
  // In C++, use std::terminate().
  if ($this().getLangOpts().CPlusPlus
     && $this().getTarget().getCXXABI().isItaniumFamily()) {
    name.$assignMove(/*STRINGREF_STR*/"_ZSt9terminatev");
  } else if ($this().getLangOpts().CPlusPlus
     && $this().getTarget().getCXXABI().isMicrosoft()) {
    if ($this().getLangOpts().isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015)) {
      name.$assignMove(/*STRINGREF_STR*/"__std_terminate");
    } else {
      name.$assignMove(/*STRINGREF_STR*/"\001?terminate@@YAXXZ");
    }
  } else if ($this().getLangOpts().ObjC1
     && $this().getLangOpts().ObjCRuntime.hasTerminate()) {
    name.$assignMove(/*STRINGREF_STR*/"objc_terminate");
  } else {
    name.$assignMove(/*STRINGREF_STR*/"abort");
  }
  return $this().CreateRuntimeFunction(FTy, new StringRef(name));
}


/// Check whether we can use a "simpler", more core exceptions personality
/// function.

/// Try to use the C++ personality function in ObjC++.  Not doing this
/// can cause some incompatibilities with gcc, which is more
/// aggressive about only using the ObjC++ personality in a function
/// when it really needs it.
//<editor-fold defaultstate="collapsed" desc="clang::CodeGen::CodeGenModule::SimplifyPersonality">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp", line = 296,
 FQN="clang::CodeGen::CodeGenModule::SimplifyPersonality", NM="_ZN5clang7CodeGen13CodeGenModule19SimplifyPersonalityEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType -split-class=clang::CodeGen::CodeGenModule@this ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGException.cpp -nm=_ZN5clang7CodeGen13CodeGenModule19SimplifyPersonalityEv")
//</editor-fold>
protected/*private*/ final void SimplifyPersonality() {
  // If we're not in ObjC++ -fexceptions, there's nothing to do.
  if (!$this().LangOpts.CPlusPlus || !$this().LangOpts.ObjC1 || !$this().LangOpts.Exceptions) {
    return;
  }
  
  // Both the problem this endeavors to fix and the way the logic
  // above works is specific to the NeXT runtime.
  if (!$this().LangOpts.ObjCRuntime.isNeXTFamily()) {
    return;
  }
  
  final /*const*/ EHPersonality /*&*/ ObjCXX = EHPersonality.get(/*Deref*/$this(), /*FD=*/ (/*const*/ FunctionDecl /*P*/ )null);
  final /*const*/ EHPersonality /*&*/ CXX = getCXXPersonality($this().getTarget().getTriple(), $this().LangOpts);
  if ($AddrOf(ObjCXX) == $AddrOf(CXX)) {
    return;
  }
  assert (std.strcmp(ObjCXX.PersonalityFn, CXX.PersonalityFn) != 0) : "Different EHPersonalities using the same personality function.";
  
  Function /*P*/ Fn = $this().getModule().getFunction(new StringRef(ObjCXX.PersonalityFn));
  
  // Nothing to do if it's unused.
  if (!(Fn != null) || Fn.use_empty()) {
    return;
  }
  
  // Can't do the optimization if it has non-C++ uses.
  if (!PersonalityHasOnlyCXXUses(Fn)) {
    return;
  }
  
  // Create the C++ personality function and kill off the old
  // function.
  Constant /*P*/ CXXFn = getPersonalityFn(/*Deref*/$this(), CXX);
  
  // This can happen if the user is screwing with us.
  if (Fn.getType() != CXXFn.getType()) {
    return;
  }
  
  Fn.replaceAllUsesWith(CXXFn);
  Fn.eraseFromParent();
}

} // END OF class CodeGenModule_CGException
