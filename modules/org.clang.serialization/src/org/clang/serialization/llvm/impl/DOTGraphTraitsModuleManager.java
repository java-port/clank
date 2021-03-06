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

package org.clang.serialization.llvm.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clang.serialization.*;
import org.llvm.support.*;

//<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ModuleManager>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 458,
 FQN="llvm::DOTGraphTraits<ModuleManager>", NM="_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEEE")
//</editor-fold>
public class/*struct*/ DOTGraphTraitsModuleManager extends /*public*/ DefaultDOTGraphTraits {
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ModuleManager>::DOTGraphTraits">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 460,
   FQN="llvm::DOTGraphTraits<ModuleManager>::DOTGraphTraits", NM="_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEEC1Eb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEEC1Eb")
  //</editor-fold>
  public /*explicit*/ DOTGraphTraitsModuleManager() {
    this(false);
  }
  public /*explicit*/ DOTGraphTraitsModuleManager(boolean IsSimple/*= false*/) {
    // : DefaultDOTGraphTraits(IsSimple) 
    //START JInit
    super(IsSimple);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ModuleManager>::renderGraphFromBottomUp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 463,
   FQN="llvm::DOTGraphTraits<ModuleManager>::renderGraphFromBottomUp", NM="_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEE23renderGraphFromBottomUpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEE23renderGraphFromBottomUpEv")
  //</editor-fold>
  public static boolean renderGraphFromBottomUp() {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ModuleManager>::getNodeLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 467,
   FQN="llvm::DOTGraphTraits<ModuleManager>::getNodeLabel", NM="_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEE12getNodeLabelEPNS2_10ModuleFileERKS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEE12getNodeLabelEPNS2_10ModuleFileERKS3_")
  //</editor-fold>
  public std.string getNodeLabel(ModuleFile /*P*/ M, final /*const*/ ModuleManager /*&*/ $Prm1) {
    return new std.string(M.ModuleName);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::DOTGraphTraits<ModuleManager>::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp", line = 459,
   FQN="llvm::DOTGraphTraits<ModuleManager>::operator=", NM="_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEEaSEOS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ModuleManager.cpp -nm=_ZN4llvm14DOTGraphTraitsIN5clang13serialization13ModuleManagerEEaSEOS4_")
  //</editor-fold>
  public /*inline*/ DOTGraphTraitsModuleManager /*&*/ $assignMove(final DOTGraphTraitsModuleManager /*&&*/$Prm0) {
    /*J:ToBase*/super.$assignMove($Prm0);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
