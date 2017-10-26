/**
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

package org.llvm.analysis.impl;

import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.StringRef;
import org.llvm.pass.*;
import org.llvm.analysis.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionViewer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 175,
 FQN="(anonymous namespace)::RegionViewer", NM="_ZN12_GLOBAL__N_112RegionViewerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN12_GLOBAL__N_112RegionViewerE")
//</editor-fold>
public class/*struct*/ RegionViewer extends /*public*/ DOTGraphTraitsViewer<RegionInfoPass, RegionInfo /*P*/ , RegionInfoPassGraphTraits>/*<false>*/ implements Destructors.ClassWithDestructor {
  // JAVA: moved to extra/*public*/ static /*char*/byte ID = $int2char(0);
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionViewer::RegionViewer">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 179,
   FQN="(anonymous namespace)::RegionViewer::RegionViewer", NM="_ZN12_GLOBAL__N_112RegionViewerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN12_GLOBAL__N_112RegionViewerC1Ev")
  //</editor-fold>
  public RegionViewer() {
    // : DOTGraphTraitsViewer<RegionInfoPass, false, RegionInfo * , RegionInfoPassGraphTraits>("reg", ID) 
    //START JInit
    /*ExprWithCleanups*/super(RegionInfoPass.class, new RegionInfoPassGraphTraits(), false, new StringRef(/*KEEP_STR*/"reg"), ID);
    //END JInit
    RegionPrinterLlvmStatics.initializeRegionViewerPass($Deref(PassRegistry.getPassRegistry()));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RegionViewer::~RegionViewer">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 175,
   FQN="(anonymous namespace)::RegionViewer::~RegionViewer", NM="_ZN12_GLOBAL__N_112RegionViewerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN12_GLOBAL__N_112RegionViewerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public static final/*char*/Class<RegionViewer> ID = RegionViewer.class;

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
