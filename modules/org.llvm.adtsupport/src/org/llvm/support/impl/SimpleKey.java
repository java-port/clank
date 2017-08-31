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

package org.llvm.support.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.support.yaml.impl.Token;
import org.llvm.support.yaml.impl.ilist_traitsToken;

/// @brief This struct is used to track simple keys.
///
/// Simple keys are handled by creating an entry in SimpleKeys for each Token
/// which could legally be the start of a simple key. When peekNext is called,
/// if the Token To be returned is referenced by a SimpleKey, we continue
/// tokenizing until that potential simple key has either been found to not be
/// a simple key (we moved on to the next line or went further than 1024 chars).
/// Or when we run into a Value, and then insert a Key token (and possibly
/// others) before the SimpleKey's Tok.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleKey">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 195,
 FQN="(anonymous namespace)::SimpleKey", NM="_ZN12_GLOBAL__N_19SimpleKeyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN12_GLOBAL__N_19SimpleKeyE")
//</editor-fold>
public class/*struct*/ SimpleKey implements Native.NativeComparable<SimpleKey> {
  public ilist_iterator<Token> Tok;
  public /*uint*/int Column;
  public /*uint*/int Line;
  public /*uint*/int FlowLevel;
  public boolean IsRequired;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleKey::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 202,
   FQN="(anonymous namespace)::SimpleKey::operator==", NM="_ZN12_GLOBAL__N_19SimpleKeyeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN12_GLOBAL__N_19SimpleKeyeqERKS0_")
  //</editor-fold>
  public boolean $eq(final /*const*/ SimpleKey /*&*/ Other) {
    return Tok.$eq(Other.Tok);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleKey::SimpleKey">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 195,
   FQN="(anonymous namespace)::SimpleKey::SimpleKey", NM="_ZN12_GLOBAL__N_19SimpleKeyC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN12_GLOBAL__N_19SimpleKeyC1Ev")
  //</editor-fold>
  public /*inline*/ SimpleKey() {
    // : Tok() 
    //START JInit
    this.Tok = new ilist_iterator<Token>(new ilist_traitsToken());
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleKey::SimpleKey">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 195,
   FQN="(anonymous namespace)::SimpleKey::SimpleKey", NM="_ZN12_GLOBAL__N_19SimpleKeyC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN12_GLOBAL__N_19SimpleKeyC1EOS0_")
  //</editor-fold>
  public /*inline*/ SimpleKey(JD$Move _dparam, final SimpleKey /*&&*/$Prm0) {
    // : Tok(static_cast<SimpleKey &&>().Tok), Column(static_cast<SimpleKey &&>().Column), Line(static_cast<SimpleKey &&>().Line), FlowLevel(static_cast<SimpleKey &&>().FlowLevel), IsRequired(static_cast<SimpleKey &&>().IsRequired) 
    //START JInit
    this.Tok = new ilist_iterator<Token>(JD$Move.INSTANCE, $Prm0.Tok);
    this.Column = $Prm0.Column;
    this.Line = $Prm0.Line;
    this.FlowLevel = $Prm0.FlowLevel;
    this.IsRequired = $Prm0.IsRequired;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SimpleKey::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp", line = 195,
   FQN="(anonymous namespace)::SimpleKey::operator=", NM="_ZN12_GLOBAL__N_19SimpleKeyaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/YAMLParser.cpp -nm=_ZN12_GLOBAL__N_19SimpleKeyaSEOS0_")
  //</editor-fold>
  public /*inline*/ SimpleKey /*&*/ $assignMove(final SimpleKey /*&&*/$Prm0) {
    this.Tok.$assignMove($Prm0.Tok);
    this.Column = $Prm0.Column;
    this.Line = $Prm0.Line;
    this.FlowLevel = $Prm0.FlowLevel;
    this.IsRequired = $Prm0.IsRequired;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Tok=" + Tok // NOI18N
              + ", Column=" + Column // NOI18N
              + ", Line=" + Line // NOI18N
              + ", FlowLevel=" + FlowLevel // NOI18N
              + ", IsRequired=" + IsRequired; // NOI18N
  }
}
