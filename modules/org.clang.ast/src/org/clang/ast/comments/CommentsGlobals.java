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
package org.clang.ast.comments;

import org.clank.support.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type CommentsGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_113isHTMLTagNameEN4llvm9StringRefE;_ZN5clang8comments12_GLOBAL__N_120isHTMLEndTagOptionalEN4llvm9StringRefE;_ZN5clang8comments12_GLOBAL__N_121isHTMLEndTagForbiddenEN4llvm9StringRefE;_ZN5clang8comments12_GLOBAL__N_142translateHTMLNamedCharacterReferenceToUTF8EN4llvm9StringRefE;_ZN5clang8comments12_GLOBAL__N_1L8CommandsE; -static-type=CommentsGlobals -package=org.clang.ast.comments")
//</editor-fold>
public final class CommentsGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::Commands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentCommandInfo.inc", line = 10,
 FQN="clang::comments::(anonymous namespace)::Commands", NM="_ZN5clang8comments12_GLOBAL__N_1L8CommandsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentCommandTraits.cpp -nm=_ZN5clang8comments12_GLOBAL__N_1L8CommandsE")
//</editor-fold>
public static /*const*/ CommandInfo Commands[/*120*/] = new /*const*/ CommandInfo [/*120*/] {
  new CommandInfo($a, $EMPTY, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("abstract"), $EMPTY, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("addtogroup"), $EMPTY, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("arg"), $EMPTY, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("attention"), $EMPTY, 4, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("author"), $EMPTY, 5, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("authors"), $EMPTY, 6, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($b, $EMPTY, 7, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("brief"), $EMPTY, 8, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("bug"), $EMPTY, 9, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($c, $EMPTY, 10, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("callback"), $EMPTY, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0), 
  new CommandInfo($("category"), $EMPTY, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($class, $EMPTY, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0), 
  new CommandInfo($("classdesign"), $EMPTY, 14, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("coclass"), $EMPTY, 15, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("code"), $("endcode"), 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endcode"), $EMPTY, 17, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($const, $EMPTY, 18, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($constant, $EMPTY, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("copyright"), $EMPTY, 20, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("date"), $EMPTY, 21, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("def"), $EMPTY, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("defgroup"), $EMPTY, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("dependency"), $EMPTY, 24, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("deprecated"), $EMPTY, 25, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("details"), $EMPTY, 26, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("discussion"), $EMPTY, 27, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("dot"), $("enddot"), 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("enddot"), $EMPTY, 29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($e, $EMPTY, 30, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("em"), $EMPTY, 31, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($enum, $EMPTY, 32, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("exception"), $EMPTY, 33, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("f{"), $("f}"), 34, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("f}"), $EMPTY, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("f["), $("f]"), 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("f]"), $EMPTY, 37, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("f$"), $("f$"), 38, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($fn, $EMPTY, 39, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("function"), $EMPTY, 40, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0), 
  new CommandInfo($("functiongroup"), $EMPTY, 41, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0), 
  new CommandInfo($("headerfile"), $EMPTY, 42, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("helper"), $EMPTY, 43, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("helperclass"), $EMPTY, 44, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("helps"), $EMPTY, 45, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("htmlonly"), $("endhtmlonly"), 46, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endhtmlonly"), $EMPTY, 47, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("ingroup"), $EMPTY, 48, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("instancesize"), $EMPTY, 49, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("interface"), $EMPTY, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0), 
  new CommandInfo($("invariant"), $EMPTY, 51, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("latexonly"), $("endlatexonly"), 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endlatexonly"), $EMPTY, 53, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("li"), $EMPTY, 54, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("link"), $("/link"), 55, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("/link"), $EMPTY, 56, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("mainpage"), $EMPTY, 57, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("manonly"), $("endmanonly"), 58, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endmanonly"), $EMPTY, 59, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("method"), $EMPTY, 60, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0), 
  new CommandInfo($("methodgroup"), $EMPTY, 61, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0), 
  new CommandInfo($("msc"), $("endmsc"), 62, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endmsc"), $EMPTY, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("name"), $EMPTY, 64, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($namespace, $EMPTY, 65, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("note"), $EMPTY, 66, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("overload"), $EMPTY, 67, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("ownership"), $EMPTY, 68, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($p, $EMPTY, 69, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("par"), $EMPTY, 70, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("paragraph"), $EMPTY, 71, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("param"), $EMPTY, 72, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("performance"), $EMPTY, 73, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("post"), $EMPTY, 74, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("pre"), $EMPTY, 75, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("property"), $EMPTY, 76, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("protocol"), $EMPTY, 77, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0), 
  new CommandInfo($("ref"), $EMPTY, 78, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("related"), $EMPTY, 79, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("relatedalso"), $EMPTY, 80, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("relates"), $EMPTY, 81, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("relatesalso"), $EMPTY, 82, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("remark"), $EMPTY, 83, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("remarks"), $EMPTY, 84, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("result"), $EMPTY, 85, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($return, $EMPTY, 86, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("returns"), $EMPTY, 87, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("rtfonly"), $("endrtfonly"), 88, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endrtfonly"), $EMPTY, 89, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("sa"), $EMPTY, 90, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("section"), $EMPTY, 91, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("security"), $EMPTY, 92, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($("see"), $EMPTY, 93, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("seealso"), $EMPTY, 94, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($short, $EMPTY, 95, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("since"), $EMPTY, 96, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($struct, $EMPTY, 97, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0), 
  new CommandInfo($("subpage"), $EMPTY, 98, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("subsection"), $EMPTY, 99, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("subsubsection"), $EMPTY, 100, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("superclass"), $EMPTY, 101, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0), 
  new CommandInfo($template, $EMPTY, 102, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("templatefield"), $EMPTY, 103, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("textblock"), $("/textblock"), 104, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("/textblock"), $EMPTY, 105, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($throw, $EMPTY, 106, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("throws"), $EMPTY, 107, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("todo"), $EMPTY, 108, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("tparam"), $EMPTY, 109, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($typedef, $EMPTY, 110, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($union, $EMPTY, 111, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0), 
  new CommandInfo($("var"), $EMPTY, 112, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0), 
  new CommandInfo($("verbatim"), $("endverbatim"), 113, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endverbatim"), $EMPTY, 114, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("version"), $EMPTY, 115, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($warning, $EMPTY, 116, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("weakgroup"), $EMPTY, 117, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0), 
  new CommandInfo($("xmlonly"), $("endxmlonly"), 118, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0), 
  new CommandInfo($("endxmlonly"), $EMPTY, 119, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0)
};
/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* HTML tag name matcher                                                      *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLTagName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLTags.inc", line = 9,
 FQN="clang::comments::(anonymous namespace)::isHTMLTagName", NM="_ZN5clang8comments12_GLOBAL__N_113isHTMLTagNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_113isHTMLTagNameEN4llvm9StringRefE")
//</editor-fold>
public static boolean isHTMLTagName(StringRef Name) {
  return /*delegate*/org.clang.ast.comments.impl.CommentHTMLTagsCommentsGlobals.
    isHTMLTagName(Name);
}

/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* HTML named character reference to UTF-8 translation                        *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::translateHTMLNamedCharacterReferenceToUTF8">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLNamedCharacterReferences.inc", line = 9,
 FQN="clang::comments::(anonymous namespace)::translateHTMLNamedCharacterReferenceToUTF8", NM="_ZN5clang8comments12_GLOBAL__N_142translateHTMLNamedCharacterReferenceToUTF8EN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentLexer.cpp -nm=_ZN5clang8comments12_GLOBAL__N_142translateHTMLNamedCharacterReferenceToUTF8EN4llvm9StringRefE")
//</editor-fold>
public static StringRef translateHTMLNamedCharacterReferenceToUTF8(StringRef Name) {
  return /*delegate*/org.clang.ast.comments.impl.CommentHTMLNamedCharacterReferencesCommentsGlobals.
    translateHTMLNamedCharacterReferenceToUTF8(Name);
}

/*===- TableGen'erated file -------------------------------------*- C++ -*-===*\
|*                                                                            *|
|* HTML tag properties                                                        *|
|*                                                                            *|
|* Automatically generated file, do not edit!                                 *|
|*                                                                            *|
\*===----------------------------------------------------------------------===*/
//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLEndTagOptional">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLTagsProperties.inc", line = 9,
 FQN="clang::comments::(anonymous namespace)::isHTMLEndTagOptional", NM="_ZN5clang8comments12_GLOBAL__N_120isHTMLEndTagOptionalEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_120isHTMLEndTagOptionalEN4llvm9StringRefE")
//</editor-fold>
public static boolean isHTMLEndTagOptional(StringRef Name) {
  return /*delegate*/org.clang.ast.comments.impl.CommentHTMLTagsPropertiesCommentsGlobals.
    isHTMLEndTagOptional(Name);
}

//<editor-fold defaultstate="collapsed" desc="clang::comments::(anonymous namespace)::isHTMLEndTagForbidden">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/build/tools/clang/include/clang/AST/CommentHTMLTagsProperties.inc", line = 72,
 FQN="clang::comments::(anonymous namespace)::isHTMLEndTagForbidden", NM="_ZN5clang8comments12_GLOBAL__N_121isHTMLEndTagForbiddenEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/CommentSema.cpp -nm=_ZN5clang8comments12_GLOBAL__N_121isHTMLEndTagForbiddenEN4llvm9StringRefE")
//</editor-fold>
public static boolean isHTMLEndTagForbidden(StringRef Name) {
  return /*delegate*/org.clang.ast.comments.impl.CommentHTMLTagsPropertiesCommentsGlobals.
    isHTMLEndTagForbidden(Name);
}

} // END OF class CommentsGlobals
