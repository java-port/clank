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
import org.clang.clangc.api.buildsystem.*;


//<editor-fold defaultstate="collapsed" desc="static type BuildSystemGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z10clang_free;_Z30clang_getBuildSessionTimestamp;_Z31clang_VirtualFileOverlay_create;_Z32clang_ModuleMapDescriptor_create;_Z32clang_VirtualFileOverlay_dispose;_Z33clang_ModuleMapDescriptor_dispose;_Z38clang_VirtualFileOverlay_writeToBuffer;_Z39clang_ModuleMapDescriptor_writeToBuffer;_Z39clang_VirtualFileOverlay_addFileMapping;_Z43clang_ModuleMapDescriptor_setUmbrellaHeader;_Z43clang_VirtualFileOverlay_setCaseSensitivity;_Z48clang_ModuleMapDescriptor_setFrameworkModuleName; -static-type=BuildSystemGlobals -package=org.clang.clangc")
//</editor-fold>
public interface BuildSystemGlobalsImplementation {


/**
* \defgroup BUILD_SYSTEM Build system utilities
* @{
*/

/**
* \brief Return the timestamp for use with Clang's
* \c -fbuild-session-timestamp= option.
*/
//<editor-fold defaultstate="collapsed" desc="clang_getBuildSessionTimestamp">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 26,
 FQN="clang_getBuildSessionTimestamp", NM="_Z30clang_getBuildSessionTimestamp",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z30clang_getBuildSessionTimestamp")
//</editor-fold>
public /*static*/ default /*ullong*/long clang_getBuildSessionTimestamp() {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Create a \c CXVirtualFileOverlay object.
* Must be disposed with \c clang_VirtualFileOverlay_dispose().
*
* \param options is reserved, always pass 0.
*/
//<editor-fold defaultstate="collapsed" desc="clang_VirtualFileOverlay_create">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 33,
 FQN="clang_VirtualFileOverlay_create", NM="_Z31clang_VirtualFileOverlay_create",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z31clang_VirtualFileOverlay_create")
//</editor-fold>
public /*static*/ default CXVirtualFileOverlay clang_VirtualFileOverlay_create(/*uint*/int $Prm0) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Map an absolute virtual file path to an absolute real one.
* The virtual path must be canonicalized (not contain "."/"..").
* \returns 0 for success, non-zero to indicate an error.
*/
//<editor-fold defaultstate="collapsed" desc="clang_VirtualFileOverlay_addFileMapping">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 37,
 FQN="clang_VirtualFileOverlay_addFileMapping", NM="_Z39clang_VirtualFileOverlay_addFileMapping",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z39clang_VirtualFileOverlay_addFileMapping")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_VirtualFileOverlay_addFileMapping(CXVirtualFileOverlay VFO, 
                                       /*const*/char$ptr/*char P*/ virtualPath, 
                                       /*const*/char$ptr/*char P*/ realPath) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Set the case sensitivity for the \c CXVirtualFileOverlay object.
* The \c CXVirtualFileOverlay object is case-sensitive by default, this
* option can be used to override the default.
* \returns 0 for success, non-zero to indicate an error.
*/
//<editor-fold defaultstate="collapsed" desc="clang_VirtualFileOverlay_setCaseSensitivity">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 60,
 FQN="clang_VirtualFileOverlay_setCaseSensitivity", NM="_Z43clang_VirtualFileOverlay_setCaseSensitivity",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z43clang_VirtualFileOverlay_setCaseSensitivity")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_VirtualFileOverlay_setCaseSensitivity(CXVirtualFileOverlay VFO, 
                                           int caseSensitive) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Write out the \c CXVirtualFileOverlay object to a char buffer.
*
* \param options is reserved, always pass 0.
* \param out_buffer_ptr pointer to receive the buffer pointer, which should be
* disposed using \c clang_free().
* \param out_buffer_size pointer to receive the buffer size.
* \returns 0 for success, non-zero to indicate an error.
*/
//<editor-fold defaultstate="collapsed" desc="clang_VirtualFileOverlay_writeToBuffer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 69,
 FQN="clang_VirtualFileOverlay_writeToBuffer", NM="_Z38clang_VirtualFileOverlay_writeToBuffer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z38clang_VirtualFileOverlay_writeToBuffer")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_VirtualFileOverlay_writeToBuffer(CXVirtualFileOverlay VFO, /*uint*/int $Prm1, 
                                      type$ptr<char$ptr>/*char PP*/ out_buffer_ptr, 
                                      uint$ptr/*uint P*/ out_buffer_size) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief free memory allocated by libclang, such as the buffer returned by
* \c CXVirtualFileOverlay() or \c clang_ModuleMapDescriptor_writeToBuffer().
*
* \param buffer memory pointer to free.
*/
//<editor-fold defaultstate="collapsed" desc="clang_free">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 87,
 FQN="clang_free", NM="_Z10clang_free",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z10clang_free")
//</editor-fold>
public /*static*/ default void clang_free(Object/*void P*/ buffer) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Dispose a \c CXVirtualFileOverlay object.
*/
//<editor-fold defaultstate="collapsed" desc="clang_VirtualFileOverlay_dispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 91,
 FQN="clang_VirtualFileOverlay_dispose", NM="_Z32clang_VirtualFileOverlay_dispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z32clang_VirtualFileOverlay_dispose")
//</editor-fold>
public /*static*/ default void clang_VirtualFileOverlay_dispose(CXVirtualFileOverlay VFO) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Create a \c CXModuleMapDescriptor object.
* Must be disposed with \c clang_ModuleMapDescriptor_dispose().
*
* \param options is reserved, always pass 0.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ModuleMapDescriptor_create">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 101,
 FQN="clang_ModuleMapDescriptor_create", NM="_Z32clang_ModuleMapDescriptor_create",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z32clang_ModuleMapDescriptor_create")
//</editor-fold>
public /*static*/ default CXModuleMapDescriptor clang_ModuleMapDescriptor_create(/*uint*/int $Prm0) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Sets the framework module name that the module.map describes.
* \returns 0 for success, non-zero to indicate an error.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ModuleMapDescriptor_setFrameworkModuleName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 105,
 FQN="clang_ModuleMapDescriptor_setFrameworkModuleName", NM="_Z48clang_ModuleMapDescriptor_setFrameworkModuleName",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z48clang_ModuleMapDescriptor_setFrameworkModuleName")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_ModuleMapDescriptor_setFrameworkModuleName(CXModuleMapDescriptor MMD, 
                                                /*const*/char$ptr/*char P*/ name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Sets the umbrealla header name that the module.map describes.
* \returns 0 for success, non-zero to indicate an error.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ModuleMapDescriptor_setUmbrellaHeader">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 115,
 FQN="clang_ModuleMapDescriptor_setUmbrellaHeader", NM="_Z43clang_ModuleMapDescriptor_setUmbrellaHeader",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z43clang_ModuleMapDescriptor_setUmbrellaHeader")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_ModuleMapDescriptor_setUmbrellaHeader(CXModuleMapDescriptor MMD, 
                                           /*const*/char$ptr/*char P*/ name) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Write out the \c CXModuleMapDescriptor object to a char buffer.
*
* \param options is reserved, always pass 0.
* \param out_buffer_ptr pointer to receive the buffer pointer, which should be
* disposed using \c clang_free().
* \param out_buffer_size pointer to receive the buffer size.
* \returns 0 for success, non-zero to indicate an error.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ModuleMapDescriptor_writeToBuffer">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 125,
 FQN="clang_ModuleMapDescriptor_writeToBuffer", NM="_Z39clang_ModuleMapDescriptor_writeToBuffer",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z39clang_ModuleMapDescriptor_writeToBuffer")
//</editor-fold>
public /*static*/ default  CXErrorCode clang_ModuleMapDescriptor_writeToBuffer(CXModuleMapDescriptor MMD, /*uint*/int $Prm1, 
                                       type$ptr<char$ptr>/*char PP*/ out_buffer_ptr, 
                                       uint$ptr/*uint P*/ out_buffer_size) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Dispose a \c CXModuleMapDescriptor object.
*/
//<editor-fold defaultstate="collapsed" desc="clang_ModuleMapDescriptor_dispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp", line = 149,
 FQN="clang_ModuleMapDescriptor_dispose", NM="_Z33clang_ModuleMapDescriptor_dispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/BuildSystem.cpp -nm=_Z33clang_ModuleMapDescriptor_dispose")
//</editor-fold>
public /*static*/ default void clang_ModuleMapDescriptor_dispose(CXModuleMapDescriptor MMD) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class BuildSystemGlobals
