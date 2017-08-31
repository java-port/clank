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

package org.llvm.transforms.ipo.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.analysis.AnalysisLlvmGlobals.isInlineViable;
import org.llvm.analysis.CallGraph;
import org.llvm.analysis.CallGraphSCC;
import org.llvm.analysis.InlineCost;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import org.llvm.target.target.*;
import org.llvm.transforms.scalar.impl.TransformsLlvmStatics;


/// \brief Inliner pass which only handles "always inline" functions.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInliner">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 38,
 FQN="(anonymous namespace)::AlwaysInliner", NM="_ZN12_GLOBAL__N_113AlwaysInlinerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN12_GLOBAL__N_113AlwaysInlinerE")
//</editor-fold>
public class AlwaysInliner extends /*public*/ Inliner implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInliner::AlwaysInliner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 41,
   FQN="(anonymous namespace)::AlwaysInliner::AlwaysInliner", NM="_ZN12_GLOBAL__N_113AlwaysInlinerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN12_GLOBAL__N_113AlwaysInlinerC1Ev")
  //</editor-fold>
  public AlwaysInliner() {
    // : Inliner(ID, /*InsertLifetime*/ true)
    //START JInit
    super(ID, true);
    //END JInit
    TransformsLlvmStatics.initializeAlwaysInlinerPass($Deref(PassRegistry.getPassRegistry()));
  }


  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInliner::AlwaysInliner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 45,
   FQN="(anonymous namespace)::AlwaysInliner::AlwaysInliner", NM="_ZN12_GLOBAL__N_113AlwaysInlinerC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN12_GLOBAL__N_113AlwaysInlinerC1Eb")
  //</editor-fold>
  public AlwaysInliner(boolean InsertLifetime) {
    // : Inliner(ID, InsertLifetime)
    //START JInit
    super(ID, InsertLifetime);
    //END JInit
    TransformsLlvmStatics.initializeAlwaysInlinerPass($Deref(PassRegistry.getPassRegistry()));
  }


  /// Main run interface method.  We override here to avoid calling skipSCC().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInliner::runOnSCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 50,
   FQN="(anonymous namespace)::AlwaysInliner::runOnSCC", NM="_ZN12_GLOBAL__N_113AlwaysInliner8runOnSCCERN4llvm12CallGraphSCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN12_GLOBAL__N_113AlwaysInliner8runOnSCCERN4llvm12CallGraphSCCE")
  //</editor-fold>
  @Override public boolean runOnSCC(final CallGraphSCC /*&*/ SCC)/* override*/ {
    return inlineCalls(SCC);
  }


  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0); // Pass identification, replacement for typeid


  /// \brief Get the inline cost for the always-inliner.
  ///
  /// The always inliner *only* handles functions which are marked with the
  /// attribute to force inlining. As such, it is dramatically simpler and avoids
  /// using the powerful (but expensive) inline cost analysis. Instead it uses
  /// a very simple and boring direct walk of the instructions looking for
  /// impossible-to-inline constructs.
  ///
  /// Note, it would be possible to go to some lengths to cache the information
  /// computed here, but as we only expect to do this for relatively few and
  /// small functions which have the explicit attribute to force inlining, it is
  /// likely not worth it in practice.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInliner::getInlineCost">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 98,
   FQN="(anonymous namespace)::AlwaysInliner::getInlineCost", NM="_ZN12_GLOBAL__N_113AlwaysInliner13getInlineCostEN4llvm8CallSiteE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN12_GLOBAL__N_113AlwaysInliner13getInlineCostEN4llvm8CallSiteE")
  //</editor-fold>
  @Override public InlineCost getInlineCost(CallSite CS)/* override*/ {
    Function /*P*/ Callee = CS.getCalledFunction();

    // Only inline direct calls to functions with always-inline attributes
    // that are viable for inlining. FIXME: We shouldn't even get here for
    // declarations.
    if ((Callee != null) && !Callee.isDeclaration()
       && CS.hasFnAttr(Attribute.AttrKind.AlwaysInline) && isInlineViable($Deref(Callee))) {
      return InlineCost.getAlways();
    }

    return InlineCost.getNever();
  }


  //JAVA: using llvm::Pass::doFinalization;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInliner::doFinalization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 57,
   FQN="(anonymous namespace)::AlwaysInliner::doFinalization", NM="_ZN12_GLOBAL__N_113AlwaysInliner14doFinalizationERN4llvm9CallGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN12_GLOBAL__N_113AlwaysInliner14doFinalizationERN4llvm9CallGraphE")
  //</editor-fold>
  @Override public boolean doFinalization(final CallGraph /*&*/ CG)/* override*/ {
    return removeDeadFunctions(CG, /*AlwaysInlineOnly=*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AlwaysInliner::~AlwaysInliner">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 38,
   FQN="(anonymous namespace)::AlwaysInliner::~AlwaysInliner", NM="_ZN12_GLOBAL__N_113AlwaysInlinerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN12_GLOBAL__N_113AlwaysInlinerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final Class<AlwaysInliner> ID = AlwaysInliner.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
