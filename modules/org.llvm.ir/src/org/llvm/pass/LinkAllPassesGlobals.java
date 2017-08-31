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

import java.util.ArrayList;
import java.util.List;
import org.clank.support.*;
import org.llvm.support.raw_string_ostream;
import org.openide.util.Lookup;


//<editor-fold defaultstate="collapsed" desc="static type LinkAllPassesGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.pass.LinkAllPassesGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN12_GLOBAL__N_116ForcePassLinkingE; -static-type=LinkAllPassesGlobals -package=org.llvm.pass")
//</editor-fold>
public final class LinkAllPassesGlobals {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ForcePassLinking">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/LinkAllPasses.h", line = 54,
 FQN="(anonymous namespace)::ForcePassLinking", NM="_ZN12_GLOBAL__N_116ForcePassLinkingE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN12_GLOBAL__N_116ForcePassLinkingE")
//</editor-fold>
public abstract static class/*struct*/ ForcePassLinking {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ForcePassLinking::ForcePassLinking">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/LinkAllPasses.h", line = 55,
   FQN="(anonymous namespace)::ForcePassLinking::ForcePassLinking", NM="_ZN12_GLOBAL__N_116ForcePassLinkingC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN12_GLOBAL__N_116ForcePassLinkingC1Ev")
  //</editor-fold>
  public ForcePassLinking() {
  }
    
  public static ForcePassLinking getInstance(){
    ArrayList<ForcePassLinking> list = new ArrayList(Lookup.getDefault().lookupAll(ForcePassLinking.class));
    ForcePassLinking main = list.remove(0);
    return main.create(list);
  }
  public abstract ForcePassLinking create(List<ForcePassLinking> services);
  public abstract void create();
  public abstract void create(raw_string_ostream os);
  public abstract void create2();

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
} // END OF class LinkAllPassesGlobals
