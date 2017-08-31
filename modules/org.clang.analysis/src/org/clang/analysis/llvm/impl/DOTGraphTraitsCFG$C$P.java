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

package org.clang.analysis.llvm.impl;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.clang.analysis.*;
import static org.clang.analysis.impl.CFGStatics.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const clang::CFG * >">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4663,
 FQN="llvm::DOTGraphTraits<const clang::CFG * >", NM="_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEEE")
//</editor-fold>
public class/*struct*/ DOTGraphTraitsCFG$C$P extends /*public*/ DefaultDOTGraphTraits {
  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const clang::CFG * >::DOTGraphTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4666,
   FQN="llvm::DOTGraphTraits<const clang::CFG * >::DOTGraphTraits", NM="_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEEC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEEC1Eb")
  //</editor-fold>
  public DOTGraphTraitsCFG$C$P() {
    this(false);
  }
  public DOTGraphTraitsCFG$C$P(boolean isSimple/*= false*/) {
    // : DefaultDOTGraphTraits(isSimple) 
    //START JInit
    super(isSimple);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const clang::CFG * >::getNodeLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4668,
   FQN="llvm::DOTGraphTraits<const clang::CFG * >::getNodeLabel", NM="_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEE12getNodeLabelEPKNS1_8CFGBlockES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEE12getNodeLabelEPKNS1_8CFGBlockES4_")
  //</editor-fold>
  public static std.string getNodeLabel(/*const*/ CFGBlock /*P*/ Node, /*const*/ CFG /*P*/ Graph) {
    raw_string_ostream Out = null;
    try {
      std.string OutSStr/*J*/= new std.string();
      Out/*J*/= new raw_string_ostream(OutSStr);
      print_block(Out, Graph, $Deref(Node), $Deref(GraphHelper), false, false);
      final std.string/*&*/ OutStr = Out.str();
      if (OutStr.$at(0) == $$LF) {
        OutStr.erase(OutStr.begin());
      }
      
      // Process string output to make it nicer...
      for (/*uint*/int i = 0; i != OutStr.length(); ++i)  {
        if (OutStr.$at(i) == $$LF) { // Left justify
          OutStr.$set(i, $$BACK_SLASH);
          OutStr.insert(OutStr.begin().$add(i).$add(1), $$l);
        }
      }
      
      return new std.string(OutStr);
    } finally {
      if (Out != null) { Out.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<const clang::CFG * >::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp", line = 4664,
   FQN="llvm::DOTGraphTraits<const clang::CFG * >::operator=", NM="_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEEaSEOS5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFG.cpp -nm=_ZN4llvm14DOTGraphTraitsIPKN5clang3CFGEEaSEOS5_")
  //</editor-fold>
  public /*inline*/ DOTGraphTraitsCFG$C$P /*&*/ $assignMove(final DOTGraphTraitsCFG$C$P /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
