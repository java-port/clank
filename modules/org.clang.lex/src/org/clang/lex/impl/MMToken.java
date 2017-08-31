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

package org.clang.lex.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clang.basic.*;

/// \brief A token in a module map file.
//<editor-fold defaultstate="collapsed" desc="clang::MMToken">
@Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 955,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 935,
 FQN = "clang::MMToken", NM = "_ZN5clang7MMTokenE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang7MMTokenE")
//</editor-fold>
public class/*struct*/ MMToken {
  //<editor-fold defaultstate="collapsed" desc="clang::MMToken::TokenKind">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 956,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 936,
   FQN = "clang::MMToken::TokenKind", NM = "_ZN5clang7MMToken9TokenKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang7MMToken9TokenKindE")
  //</editor-fold>
  public static final class/*enum*/ TokenKind {
    public static final /*TokenKind*/char Comma = 0;
    public static final /*TokenKind*/char ConfigMacros = Comma + 1;
    public static final /*TokenKind*/char Conflict = ConfigMacros + 1;
    public static final /*TokenKind*/char EndOfFile = Conflict + 1;
    public static final /*TokenKind*/char HeaderKeyword = EndOfFile + 1;
    public static final /*TokenKind*/char Identifier = HeaderKeyword + 1;
    public static final /*TokenKind*/char Exclaim = Identifier + 1;
    public static final /*TokenKind*/char ExcludeKeyword = Exclaim + 1;
    public static final /*TokenKind*/char ExplicitKeyword = ExcludeKeyword + 1;
    public static final /*TokenKind*/char ExportKeyword = ExplicitKeyword + 1;
    public static final /*TokenKind*/char ExternKeyword = ExportKeyword + 1;
    public static final /*TokenKind*/char FrameworkKeyword = ExternKeyword + 1;
    public static final /*TokenKind*/char LinkKeyword = FrameworkKeyword + 1;
    public static final /*TokenKind*/char ModuleKeyword = LinkKeyword + 1;
    public static final /*TokenKind*/char Period = ModuleKeyword + 1;
    public static final /*TokenKind*/char PrivateKeyword = Period + 1;
    public static final /*TokenKind*/char UmbrellaKeyword = PrivateKeyword + 1;
    public static final /*TokenKind*/char UseKeyword = UmbrellaKeyword + 1;
    public static final /*TokenKind*/char RequiresKeyword = UseKeyword + 1;
    public static final /*TokenKind*/char Star = RequiresKeyword + 1;
    public static final /*TokenKind*/char StringLiteral = Star + 1;
    public static final /*TokenKind*/char TextualKeyword = StringLiteral + 1;
    public static final /*TokenKind*/char LBrace = TextualKeyword + 1;
    public static final /*TokenKind*/char RBrace = LBrace + 1;
    public static final /*TokenKind*/char LSquare = RBrace + 1;
    public static final /*TokenKind*/char RSquare = LSquare + 1;
  };
  public /*TokenKind*/char Kind;
  
  public /*uint*/int Location;
  public /*uint*/int StringLength;
  public /*const*/char$ptr/*char P*/ StringData;
  
  //<editor-fold defaultstate="collapsed" desc="clang::MMToken::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 989,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 969,
   FQN = "clang::MMToken::clear", NM = "_ZN5clang7MMToken5clearEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang7MMToken5clearEv")
  //</editor-fold>
  public void clear() {
    Kind = TokenKind.EndOfFile;
    Location = 0;
    StringLength = 0;
    StringData = null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MMToken::is">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 996,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 976,
   FQN = "clang::MMToken::is", NM = "_ZNK5clang7MMToken2isENS0_9TokenKindE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang7MMToken2isENS0_9TokenKindE")
  //</editor-fold>
  public boolean is(/*TokenKind*/char K) /*const*/ {
    return Kind == K;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MMToken::getLocation">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 998,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 978,
   FQN = "clang::MMToken::getLocation", NM = "_ZNK5clang7MMToken11getLocationEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang7MMToken11getLocationEv")
  //</editor-fold>
  public SourceLocation getLocation() /*const*/ {
    return SourceLocation.getFromRawEncoding(Location);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::MMToken::getString">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 1002,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 982,
   FQN = "clang::MMToken::getString", NM = "_ZNK5clang7MMToken9getStringEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZNK5clang7MMToken9getStringEv")
  //</editor-fold>
  public StringRef getString() /*const*/ {
    return new StringRef(StringData, StringLength);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::MMToken::MMToken">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", line = 955,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp", old_line = 935,
   FQN = "clang::MMToken::MMToken", NM = "_ZN5clang7MMTokenC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/ModuleMap.cpp -nm=_ZN5clang7MMTokenC1Ev")
  //</editor-fold>
  public /*inline*/ MMToken() {
  }

  
  public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Location=" + Location // NOI18N
              + ", StringLength=" + StringLength // NOI18N
              + ", StringData=" + StringData; // NOI18N
  }
}
