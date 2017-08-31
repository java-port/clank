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

package org.llvm.pass;

import org.clank.support.*;
import org.clank.support.aliases.*;


//===---------------------------------------------------------------------------
/// RegisterPass<t> template - This template class is used to notify the system
/// that a Pass is available for use, and registers it into the internal
/// database maintained by the PassManager.  Unless this template is used, opt,
/// for example will not be able to see the pass and attempts to create the pass
/// will fail. This template is used in the follow manner (at global scope, in
/// your .cpp file):
///
/// static RegisterPass<YourPassClassName> tmp("passopt", "My Pass Name");
///
/// This statement will cause your pass to be created by calling the default
/// constructor exposed by the pass.  If you have a different constructor that
/// must be called, create a global constructor function (which takes the
/// arguments you need and returns a Pass*) and register your pass like this:
///
/// static RegisterPass<PassClassName> tmp("passopt", "My Name");
///
/*template <typename passName> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::RegisterPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 102,
 FQN="llvm::RegisterPass", NM="_ZN4llvm12RegisterPassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm12RegisterPassE")
//</editor-fold>
public class/*struct*/ RegisterPass</*typename*/ passName>  extends /*public*/ PassInfo implements Destructors.ClassWithDestructor {
  // Register Pass using default constructor...
  //<editor-fold defaultstate="collapsed" desc="llvm::RegisterPass::RegisterPass<passName>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 104,
   FQN="llvm::RegisterPass::RegisterPass<passName>", NM="_ZN4llvm12RegisterPassC1EPKcS2_bb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/Pass.cpp -nm=_ZN4llvm12RegisterPassC1EPKcS2_bb")
  //</editor-fold>
  public RegisterPass(Class<passName> cls, /*const*/char$ptr/*char P*/ PassArg, /*const*/char$ptr/*char P*/ Name) {
    this(cls, PassArg, Name, false, 
      false);
  }
  public RegisterPass(Class<passName> cls, /*const*/char$ptr/*char P*/ PassArg, /*const*/char$ptr/*char P*/ Name, boolean CFGOnly/*= false*/) {
    this(cls, PassArg, Name, CFGOnly, 
      false);
  }
  public RegisterPass(Class<passName> cls, /*const*/char$ptr/*char P*/ PassArg, /*const*/char$ptr/*char P*/ Name, boolean CFGOnly/*= false*/, 
      boolean is_analysis/*= false*/) {
    // : PassInfo(Name, PassArg, &passName::ID, PassInfo::NormalCtor_t(callDefaultCtor<passName>), CFGOnly, is_analysis) 
    //START JInit
    /*ParenListExpr*/super(Name, PassArg, cls/*$AddrOf(passName.ID)*/, () -> IrLlvmGlobals.callDefaultCtor(cls),
            //callDefaultCtor<passName>),
            CFGOnly, is_analysis);
    //END JInit
    PassRegistry.getPassRegistry().registerPass(/*Deref*/this);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
