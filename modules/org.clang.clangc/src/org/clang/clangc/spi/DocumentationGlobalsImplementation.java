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
package org.clang.clangc.spi;

import org.clang.clangc.*;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.llvm.cl.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.clangc.CXStringGlobals.*;
import org.clang.clangc.DocumentationGlobals.CXComment;
import org.clang.clangc.IndexGlobals.*;
import org.clang.clangc.api.*;


//<editor-fold defaultstate="collapsed" desc="static type DocumentationGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_CXComment;_Z21clang_Comment_getKind;_Z22clang_Comment_getChild;_Z25clang_TextComment_getText;_Z26clang_Comment_isWhitespace;_Z26clang_FullComment_getAsXML;_Z27clang_FullComment_getAsHTML;_Z28clang_Comment_getNumChildren;_Z29clang_Cursor_getParsedComment;_Z30clang_HTMLStartTag_getAttrName;_Z30clang_HTMLStartTag_getNumAttrs;_Z31clang_HTMLStartTag_getAttrValue;_Z31clang_HTMLTagComment_getTagName;_Z32clang_HTMLTagComment_getAsString;_Z33clang_VerbatimLineComment_getText;_Z35clang_TParamCommandComment_getDepth;_Z35clang_TParamCommandComment_getIndex;_Z36clang_BlockCommandComment_getArgText;_Z36clang_BlockCommandComment_getNumArgs;_Z37clang_InlineCommandComment_getArgText;_Z37clang_InlineCommandComment_getNumArgs;_Z38clang_BlockCommandComment_getParagraph;_Z38clang_ParamCommandComment_getDirection;_Z38clang_ParamCommandComment_getParamName;_Z38clang_VerbatimBlockLineComment_getText;_Z39clang_HTMLStartTagComment_isSelfClosing;_Z39clang_ParamCommandComment_getParamIndex;_Z39clang_TParamCommandComment_getParamName;_Z40clang_BlockCommandComment_getCommandName;_Z40clang_InlineCommandComment_getRenderKind;_Z41clang_InlineCommandComment_getCommandName;_Z43clang_ParamCommandComment_isParamIndexValid;_Z45clang_InlineContentComment_hasTrailingNewline;_Z45clang_ParamCommandComment_isDirectionExplicit;_Z47clang_TParamCommandComment_isParamPositionValid; -static-type=DocumentationGlobals -package=org.clang.clangc")
//</editor-fold>
public interface DocumentationGlobalsImplementation {


/**
* \defgroup CINDEX_COMMENT Comment introspection
*
* The routines in this group provide access to information in documentation
* comments. These facilities are distinct from the core and may be subject to
* their own schedule of stability and deprecation.
*
* @{
*/

/**
* \brief Given a cursor that represents a documentable entity (e.g.,
* declaration), return the associated parsed comment as a
* \c CXComment_FullComment AST node.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Cursor_getParsedComment">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 32,
 FQN="clang_Cursor_getParsedComment", NM="_Z29clang_Cursor_getParsedComment",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z29clang_Cursor_getParsedComment")
//</editor-fold>
public /*static*/ default  CXComment clang_Cursor_getParsedComment( CXCursor C) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment AST node of any kind.
*
* \returns the type of the AST node.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Comment_getKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 45,
 FQN="clang_Comment_getKind", NM="_Z21clang_Comment_getKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z21clang_Comment_getKind")
//</editor-fold>
public /*static*/ default  CXCommentKind clang_Comment_getKind( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment AST node of any kind.
*
* \returns number of children of the AST node.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Comment_getNumChildren">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 93,
 FQN="clang_Comment_getNumChildren", NM="_Z28clang_Comment_getNumChildren",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z28clang_Comment_getNumChildren")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Comment_getNumChildren( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment AST node of any kind.
*
* \param ChildIdx child index (zero-based).
*
* \returns the specified child of the AST node.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Comment_getChild">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 101,
 FQN="clang_Comment_getChild", NM="_Z22clang_Comment_getChild",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z22clang_Comment_getChild")
//</editor-fold>
public /*static*/ default  CXComment clang_Comment_getChild( CXComment CXC, /*uint*/int ChildIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief A \c CXComment_Paragraph node is considered whitespace if it contains
* only \c CXComment_Text nodes that are empty or whitespace.
*
* Other AST nodes (except \c CXComment_Paragraph and \c CXComment_Text) are
* never considered whitespace.
*
* \returns non-zero if \c Comment is whitespace.
*/
//<editor-fold defaultstate="collapsed" desc="clang_Comment_isWhitespace">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 109,
 FQN="clang_Comment_isWhitespace", NM="_Z26clang_Comment_isWhitespace",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z26clang_Comment_isWhitespace")
//</editor-fold>
public /*static*/ default /*uint*/int clang_Comment_isWhitespace( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \returns non-zero if \c Comment is inline content and has a newline
* immediately following it in the comment text.  Newlines between paragraphs
* do not count.
*/
//<editor-fold defaultstate="collapsed" desc="clang_InlineContentComment_hasTrailingNewline">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 123,
 FQN="clang_InlineContentComment_hasTrailingNewline", NM="_Z45clang_InlineContentComment_hasTrailingNewline",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z45clang_InlineContentComment_hasTrailingNewline")
//</editor-fold>
public /*static*/ default /*uint*/int clang_InlineContentComment_hasTrailingNewline( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_Text AST node.
*
* \returns text contained in the AST node.
*/
//<editor-fold defaultstate="collapsed" desc="clang_TextComment_getText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 131,
 FQN="clang_TextComment_getText", NM="_Z25clang_TextComment_getText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z25clang_TextComment_getText")
//</editor-fold>
public /*static*/ default  CXString clang_TextComment_getText( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_InlineCommand AST node.
*
* \returns name of the inline command.
*/
//<editor-fold defaultstate="collapsed" desc="clang_InlineCommandComment_getCommandName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 139,
 FQN="clang_InlineCommandComment_getCommandName", NM="_Z41clang_InlineCommandComment_getCommandName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z41clang_InlineCommandComment_getCommandName")
//</editor-fold>
public /*static*/ default  CXString clang_InlineCommandComment_getCommandName( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_InlineCommand AST node.
*
* \returns the most appropriate rendering mode, chosen on command
* semantics in Doxygen.
*/
//<editor-fold defaultstate="collapsed" desc="clang_InlineCommandComment_getRenderKind">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 148,
 FQN="clang_InlineCommandComment_getRenderKind", NM="_Z40clang_InlineCommandComment_getRenderKind",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z40clang_InlineCommandComment_getRenderKind")
//</editor-fold>
public /*static*/ default  CXCommentInlineCommandRenderKind clang_InlineCommandComment_getRenderKind( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_InlineCommand AST node.
*
* \returns number of command arguments.
*/
//<editor-fold defaultstate="collapsed" desc="clang_InlineCommandComment_getNumArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 170,
 FQN="clang_InlineCommandComment_getNumArgs", NM="_Z37clang_InlineCommandComment_getNumArgs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z37clang_InlineCommandComment_getNumArgs")
//</editor-fold>
public /*static*/ default /*uint*/int clang_InlineCommandComment_getNumArgs( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_InlineCommand AST node.
*
* \param ArgIdx argument index (zero-based).
*
* \returns text of the specified argument.
*/
//<editor-fold defaultstate="collapsed" desc="clang_InlineCommandComment_getArgText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 178,
 FQN="clang_InlineCommandComment_getArgText", NM="_Z37clang_InlineCommandComment_getArgText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z37clang_InlineCommandComment_getArgText")
//</editor-fold>
public /*static*/ default  CXString clang_InlineCommandComment_getArgText( CXComment CXC, 
                                     /*uint*/int ArgIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_HTMLStartTag or \c CXComment_HTMLEndTag AST
* node.
*
* \returns HTML tag name.
*/
//<editor-fold defaultstate="collapsed" desc="clang_HTMLTagComment_getTagName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 187,
 FQN="clang_HTMLTagComment_getTagName", NM="_Z31clang_HTMLTagComment_getTagName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z31clang_HTMLTagComment_getTagName")
//</editor-fold>
public /*static*/ default  CXString clang_HTMLTagComment_getTagName( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_HTMLStartTag AST node.
*
* \returns non-zero if tag is self-closing (for example, &lt;br /&gt;).
*/
//<editor-fold defaultstate="collapsed" desc="clang_HTMLStartTagComment_isSelfClosing">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 195,
 FQN="clang_HTMLStartTagComment_isSelfClosing", NM="_Z39clang_HTMLStartTagComment_isSelfClosing",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z39clang_HTMLStartTagComment_isSelfClosing")
//</editor-fold>
public /*static*/ default /*uint*/int clang_HTMLStartTagComment_isSelfClosing( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_HTMLStartTag AST node.
*
* \returns number of attributes (name-value pairs) attached to the start tag.
*/
//<editor-fold defaultstate="collapsed" desc="clang_HTMLStartTag_getNumAttrs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 203,
 FQN="clang_HTMLStartTag_getNumAttrs", NM="_Z30clang_HTMLStartTag_getNumAttrs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z30clang_HTMLStartTag_getNumAttrs")
//</editor-fold>
public /*static*/ default /*uint*/int clang_HTMLStartTag_getNumAttrs( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_HTMLStartTag AST node.
*
* \param AttrIdx attribute index (zero-based).
*
* \returns name of the specified attribute.
*/
//<editor-fold defaultstate="collapsed" desc="clang_HTMLStartTag_getAttrName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 211,
 FQN="clang_HTMLStartTag_getAttrName", NM="_Z30clang_HTMLStartTag_getAttrName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z30clang_HTMLStartTag_getAttrName")
//</editor-fold>
public /*static*/ default  CXString clang_HTMLStartTag_getAttrName( CXComment CXC, /*uint*/int AttrIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_HTMLStartTag AST node.
*
* \param AttrIdx attribute index (zero-based).
*
* \returns value of the specified attribute.
*/
//<editor-fold defaultstate="collapsed" desc="clang_HTMLStartTag_getAttrValue">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 219,
 FQN="clang_HTMLStartTag_getAttrValue", NM="_Z31clang_HTMLStartTag_getAttrValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z31clang_HTMLStartTag_getAttrValue")
//</editor-fold>
public /*static*/ default  CXString clang_HTMLStartTag_getAttrValue( CXComment CXC, /*uint*/int AttrIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_BlockCommand AST node.
*
* \returns name of the block command.
*/
//<editor-fold defaultstate="collapsed" desc="clang_BlockCommandComment_getCommandName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 227,
 FQN="clang_BlockCommandComment_getCommandName", NM="_Z40clang_BlockCommandComment_getCommandName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z40clang_BlockCommandComment_getCommandName")
//</editor-fold>
public /*static*/ default  CXString clang_BlockCommandComment_getCommandName( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_BlockCommand AST node.
*
* \returns number of word-like arguments.
*/
//<editor-fold defaultstate="collapsed" desc="clang_BlockCommandComment_getNumArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 236,
 FQN="clang_BlockCommandComment_getNumArgs", NM="_Z36clang_BlockCommandComment_getNumArgs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z36clang_BlockCommandComment_getNumArgs")
//</editor-fold>
public /*static*/ default /*uint*/int clang_BlockCommandComment_getNumArgs( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_BlockCommand AST node.
*
* \param ArgIdx argument index (zero-based).
*
* \returns text of the specified word-like argument.
*/
//<editor-fold defaultstate="collapsed" desc="clang_BlockCommandComment_getArgText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 244,
 FQN="clang_BlockCommandComment_getArgText", NM="_Z36clang_BlockCommandComment_getArgText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z36clang_BlockCommandComment_getArgText")
//</editor-fold>
public /*static*/ default  CXString clang_BlockCommandComment_getArgText( CXComment CXC, 
                                    /*uint*/int ArgIdx) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_BlockCommand or
* \c CXComment_VerbatimBlockCommand AST node.
*
* \returns paragraph argument of the block command.
*/
//<editor-fold defaultstate="collapsed" desc="clang_BlockCommandComment_getParagraph">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 253,
 FQN="clang_BlockCommandComment_getParagraph", NM="_Z38clang_BlockCommandComment_getParagraph",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z38clang_BlockCommandComment_getParagraph")
//</editor-fold>
public /*static*/ default  CXComment clang_BlockCommandComment_getParagraph( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_ParamCommand AST node.
*
* \returns parameter name.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ParamCommandComment_getParamName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 261,
 FQN="clang_ParamCommandComment_getParamName", NM="_Z38clang_ParamCommandComment_getParamName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z38clang_ParamCommandComment_getParamName")
//</editor-fold>
public /*static*/ default  CXString clang_ParamCommandComment_getParamName( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_ParamCommand AST node.
*
* \returns non-zero if the parameter that this AST node represents was found
* in the function prototype and \c clang_ParamCommandComment_getParamIndex
* function will return a meaningful value.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ParamCommandComment_isParamIndexValid">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 269,
 FQN="clang_ParamCommandComment_isParamIndexValid", NM="_Z43clang_ParamCommandComment_isParamIndexValid",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z43clang_ParamCommandComment_isParamIndexValid")
//</editor-fold>
public /*static*/ default /*uint*/int clang_ParamCommandComment_isParamIndexValid( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_ParamCommand AST node.
*
* \returns zero-based parameter index in function prototype.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ParamCommandComment_getParamIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 277,
 FQN="clang_ParamCommandComment_getParamIndex", NM="_Z39clang_ParamCommandComment_getParamIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z39clang_ParamCommandComment_getParamIndex")
//</editor-fold>
public /*static*/ default /*uint*/int clang_ParamCommandComment_getParamIndex( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_ParamCommand AST node.
*
* \returns non-zero if parameter passing direction was specified explicitly in
* the comment.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ParamCommandComment_isDirectionExplicit">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 285,
 FQN="clang_ParamCommandComment_isDirectionExplicit", NM="_Z45clang_ParamCommandComment_isDirectionExplicit",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z45clang_ParamCommandComment_isDirectionExplicit")
//</editor-fold>
public /*static*/ default /*uint*/int clang_ParamCommandComment_isDirectionExplicit( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_ParamCommand AST node.
*
* \returns parameter passing direction.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ParamCommandComment_getDirection">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 293,
 FQN="clang_ParamCommandComment_getDirection", NM="_Z38clang_ParamCommandComment_getDirection",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z38clang_ParamCommandComment_getDirection")
//</editor-fold>
public /*static*/ default  CXCommentParamPassDirection clang_ParamCommandComment_getDirection( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_TParamCommand AST node.
*
* \returns template parameter name.
*/
//<editor-fold defaultstate="collapsed" desc="clang_TParamCommandComment_getParamName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 312,
 FQN="clang_TParamCommandComment_getParamName", NM="_Z39clang_TParamCommandComment_getParamName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z39clang_TParamCommandComment_getParamName")
//</editor-fold>
public /*static*/ default  CXString clang_TParamCommandComment_getParamName( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_TParamCommand AST node.
*
* \returns non-zero if the parameter that this AST node represents was found
* in the template parameter list and
* \c clang_TParamCommandComment_getDepth and
* \c clang_TParamCommandComment_getIndex functions will return a meaningful
* value.
*/
//<editor-fold defaultstate="collapsed" desc="clang_TParamCommandComment_isParamPositionValid">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 320,
 FQN="clang_TParamCommandComment_isParamPositionValid", NM="_Z47clang_TParamCommandComment_isParamPositionValid",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z47clang_TParamCommandComment_isParamPositionValid")
//</editor-fold>
public /*static*/ default /*uint*/int clang_TParamCommandComment_isParamPositionValid( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_TParamCommand AST node.
*
* \returns zero-based nesting depth of this parameter in the template parameter list.
*
* For example,
* \verbatim
*     template<typename C, template<typename T> class TT>
*     void test(TT<int> aaa);
* \endverbatim
* for C and TT nesting depth is 0,
* for T nesting depth is 1.
*/
//<editor-fold defaultstate="collapsed" desc="clang_TParamCommandComment_getDepth">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 328,
 FQN="clang_TParamCommandComment_getDepth", NM="_Z35clang_TParamCommandComment_getDepth",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z35clang_TParamCommandComment_getDepth")
//</editor-fold>
public /*static*/ default /*uint*/int clang_TParamCommandComment_getDepth( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_TParamCommand AST node.
*
* \returns zero-based parameter index in the template parameter list at a
* given nesting depth.
*
* For example,
* \verbatim
*     template<typename C, template<typename T> class TT>
*     void test(TT<int> aaa);
* \endverbatim
* for C and TT nesting depth is 0, so we can ask for index at depth 0:
* at depth 0 C's index is 0, TT's index is 1.
*
* For T nesting depth is 1, so we can ask for index at depth 0 and 1:
* at depth 0 T's index is 1 (same as TT's),
* at depth 1 T's index is 0.
*/
//<editor-fold defaultstate="collapsed" desc="clang_TParamCommandComment_getIndex">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 336,
 FQN="clang_TParamCommandComment_getIndex", NM="_Z35clang_TParamCommandComment_getIndex",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z35clang_TParamCommandComment_getIndex")
//</editor-fold>
public /*static*/ default /*uint*/int clang_TParamCommandComment_getIndex( CXComment CXC, /*uint*/int Depth) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_VerbatimBlockLine AST node.
*
* \returns text contained in the AST node.
*/
//<editor-fold defaultstate="collapsed" desc="clang_VerbatimBlockLineComment_getText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 344,
 FQN="clang_VerbatimBlockLineComment_getText", NM="_Z38clang_VerbatimBlockLineComment_getText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z38clang_VerbatimBlockLineComment_getText")
//</editor-fold>
public /*static*/ default  CXString clang_VerbatimBlockLineComment_getText( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \param Comment a \c CXComment_VerbatimLine AST node.
*
* \returns text contained in the AST node.
*/
//<editor-fold defaultstate="collapsed" desc="clang_VerbatimLineComment_getText">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 353,
 FQN="clang_VerbatimLineComment_getText", NM="_Z33clang_VerbatimLineComment_getText",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z33clang_VerbatimLineComment_getText")
//</editor-fold>
public /*static*/ default  CXString clang_VerbatimLineComment_getText( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Convert an HTML tag AST node to string.
*
* \param Comment a \c CXComment_HTMLStartTag or \c CXComment_HTMLEndTag AST
* node.
*
* \returns string containing an HTML tag.
*/

//===----------------------------------------------------------------------===//
// Converting comments to XML.
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="clang_HTMLTagComment_getAsString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 365,
 FQN="clang_HTMLTagComment_getAsString", NM="_Z32clang_HTMLTagComment_getAsString",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z32clang_HTMLTagComment_getAsString")
//</editor-fold>
public /*static*/ default  CXString clang_HTMLTagComment_getAsString( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Convert a given full parsed comment to an HTML fragment.
*
* Specific details of HTML layout are subject to change.  Don't try to parse
* this HTML back into an AST, use other APIs instead.
*
* Currently the following CSS classes are used:
* \li "para-brief" for \\brief paragraph and equivalent commands;
* \li "para-returns" for \\returns paragraph and equivalent commands;
* \li "word-returns" for the "Returns" word in \\returns paragraph.
*
* Function argument documentation is rendered as a \<dl\> list with arguments
* sorted in function prototype order.  CSS classes used:
* \li "param-name-index-NUMBER" for parameter name (\<dt\>);
* \li "param-descr-index-NUMBER" for parameter description (\<dd\>);
* \li "param-name-index-invalid" and "param-descr-index-invalid" are used if
* parameter index is invalid.
*
* Template parameter documentation is rendered as a \<dl\> list with
* parameters sorted in template parameter list order.  CSS classes used:
* \li "tparam-name-index-NUMBER" for parameter name (\<dt\>);
* \li "tparam-descr-index-NUMBER" for parameter description (\<dd\>);
* \li "tparam-name-index-other" and "tparam-descr-index-other" are used for
* names inside template template parameters;
* \li "tparam-name-index-invalid" and "tparam-descr-index-invalid" are used if
* parameter position is invalid.
*
* \param Comment a \c CXComment_FullComment AST node.
*
* \returns string containing an HTML fragment.
*/
//<editor-fold defaultstate="collapsed" desc="clang_FullComment_getAsHTML">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 380,
 FQN="clang_FullComment_getAsHTML", NM="_Z27clang_FullComment_getAsHTML",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z27clang_FullComment_getAsHTML")
//</editor-fold>
public /*static*/ default  CXString clang_FullComment_getAsHTML( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Convert a given full parsed comment to an XML document.
*
* A Relax NG schema for the XML can be found in comment-xml-schema.rng file
* inside clang source tree.
*
* \param Comment a \c CXComment_FullComment AST node.
*
* \returns string containing an XML document.
*/
//<editor-fold defaultstate="collapsed" desc="clang_FullComment_getAsXML">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp", line = 395,
 FQN="clang_FullComment_getAsXML", NM="_Z26clang_FullComment_getAsXML",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXComment.cpp -nm=_Z26clang_FullComment_getAsXML")
//</editor-fold>
public /*static*/ default  CXString clang_FullComment_getAsXML( CXComment CXC) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class DocumentationGlobals
