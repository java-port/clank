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
import org.clang.clangc.CXCompilationDatabaseGlobals.*;
import org.clank.java.stdimpl.aliases.*;
import org.clang.clangc.CXStringGlobals.*;
import org.clang.clangc.api.buildsystem.*;


//<editor-fold defaultstate="collapsed" desc="static type CXCompilationDatabaseGlobals">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_CXCompilationDatabase_Error;_Z27clang_CompileCommand_getArg;_Z29clang_CompileCommands_dispose;_Z29clang_CompileCommands_getSize;_Z31clang_CompileCommand_getNumArgs;_Z32clang_CompileCommand_getFilename;_Z32clang_CompileCommands_getCommand;_Z33clang_CompilationDatabase_dispose;_Z33clang_CompileCommand_getDirectory;_Z39clang_CompilationDatabase_fromDirectory;_Z40clang_CompileCommand_getMappedSourcePath;_Z40clang_CompileCommand_getNumMappedSources;_Z43clang_CompileCommand_getMappedSourceContent;_Z44clang_CompilationDatabase_getCompileCommands;_Z47clang_CompilationDatabase_getAllCompileCommands; -static-type=CXCompilationDatabaseGlobals -package=org.clang.clangc")
//</editor-fold>
public interface CXCompilationDatabaseGlobalsImplementation {


/**
* \brief Creates a compilation database from the database found in directory
* buildDir. For example, CMake can output a compile_commands.json which can
* be used to build the database.
*
* It must be freed by \c clang_CompilationDatabase_dispose.
*/

// FIXME: do something more useful with the error message
//<editor-fold defaultstate="collapsed" desc="clang_CompilationDatabase_fromDirectory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 12,
 FQN="clang_CompilationDatabase_fromDirectory", NM="_Z39clang_CompilationDatabase_fromDirectory",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z39clang_CompilationDatabase_fromDirectory")
//</editor-fold>
public /*static*/ default CXCompilationDatabase clang_CompilationDatabase_fromDirectory(/*const*/char$ptr/*char P*/ BuildDir, 
                                        CXCompilationDatabase_Error /*P*/ ErrorCode) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Free the given compilation database
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompilationDatabase_dispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 33,
 FQN="clang_CompilationDatabase_dispose", NM="_Z33clang_CompilationDatabase_dispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z33clang_CompilationDatabase_dispose")
//</editor-fold>
public /*static*/ default void clang_CompilationDatabase_dispose(CXCompilationDatabase CDb) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Find the compile commands used for a file. The compile commands
* must be freed by \c clang_CompileCommands_dispose.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompilationDatabase_getCompileCommands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 47,
 FQN="clang_CompilationDatabase_getCompileCommands", NM="_Z44clang_CompilationDatabase_getCompileCommands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z44clang_CompilationDatabase_getCompileCommands")
//</editor-fold>
public /*static*/ default CXCompileCommands clang_CompilationDatabase_getCompileCommands(CXCompilationDatabase CDb, 
                                            /*const*/char$ptr/*char P*/ CompleteFileName) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get all the compile commands in the given compilation database.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompilationDatabase_getAllCompileCommands">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 60,
 FQN="clang_CompilationDatabase_getAllCompileCommands", NM="_Z47clang_CompilationDatabase_getAllCompileCommands",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z47clang_CompilationDatabase_getAllCompileCommands")
//</editor-fold>
public /*static*/ default CXCompileCommands clang_CompilationDatabase_getAllCompileCommands(CXCompilationDatabase CDb) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Free the given CompileCommands
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommands_dispose">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 71,
 FQN="clang_CompileCommands_dispose", NM="_Z29clang_CompileCommands_dispose",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z29clang_CompileCommands_dispose")
//</editor-fold>
public /*static*/ default void clang_CompileCommands_dispose(CXCompileCommands Cmds) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the number of CompileCommand we have for a file
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommands_getSize">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 77,
 FQN="clang_CompileCommands_getSize", NM="_Z29clang_CompileCommands_getSize",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z29clang_CompileCommands_getSize")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CompileCommands_getSize(CXCompileCommands Cmds) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the I'th CompileCommand for a file
*
* Note : 0 <= i < clang_CompileCommands_getSize(CXCompileCommands)
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommands_getCommand">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 89,
 FQN="clang_CompileCommands_getCommand", NM="_Z32clang_CompileCommands_getCommand",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z32clang_CompileCommands_getCommand")
//</editor-fold>
public /*static*/ default CXCompileCommand clang_CompileCommands_getCommand(CXCompileCommands Cmds, /*uint*/int I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the working directory where the CompileCommand was executed from
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommand_getDirectory">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 104,
 FQN="clang_CompileCommand_getDirectory", NM="_Z33clang_CompileCommand_getDirectory",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z33clang_CompileCommand_getDirectory")
//</editor-fold>
public /*static*/ default CXString clang_CompileCommand_getDirectory(CXCompileCommand CCmd) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the filename associated with the CompileCommand.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommand_getFilename">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 114,
 FQN="clang_CompileCommand_getFilename", NM="_Z32clang_CompileCommand_getFilename",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z32clang_CompileCommand_getFilename")
//</editor-fold>
public /*static*/ default CXString clang_CompileCommand_getFilename(CXCompileCommand CCmd) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the number of arguments in the compiler invocation.
*
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommand_getNumArgs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 124,
 FQN="clang_CompileCommand_getNumArgs", NM="_Z31clang_CompileCommand_getNumArgs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z31clang_CompileCommand_getNumArgs")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CompileCommand_getNumArgs(CXCompileCommand CCmd) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the I'th argument value in the compiler invocations
*
* Invariant :
*  - argument 0 is the compiler executable
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommand_getArg">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 133,
 FQN="clang_CompileCommand_getArg", NM="_Z27clang_CompileCommand_getArg",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z27clang_CompileCommand_getArg")
//</editor-fold>
public /*static*/ default CXString clang_CompileCommand_getArg(CXCompileCommand CCmd, /*uint*/int Arg) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the number of source mappings for the compiler invocation.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommand_getNumMappedSources">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 147,
 FQN="clang_CompileCommand_getNumMappedSources", NM="_Z40clang_CompileCommand_getNumMappedSources",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z40clang_CompileCommand_getNumMappedSources")
//</editor-fold>
public /*static*/ default /*uint*/int clang_CompileCommand_getNumMappedSources(CXCompileCommand CCmd) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the I'th mapped source path for the compiler invocation.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommand_getMappedSourcePath">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 156,
 FQN="clang_CompileCommand_getMappedSourcePath", NM="_Z40clang_CompileCommand_getMappedSourcePath",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z40clang_CompileCommand_getMappedSourcePath")
//</editor-fold>
public /*static*/ default CXString clang_CompileCommand_getMappedSourcePath(CXCompileCommand CCmd, /*uint*/int I) {
  throw new UnsupportedOperationException("EmptyBody");
}


/**
* \brief Get the I'th mapped source content for the compiler invocation.
*/
//<editor-fold defaultstate="collapsed" desc="clang_CompileCommand_getMappedSourceContent">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp", line = 170,
 FQN="clang_CompileCommand_getMappedSourceContent", NM="_Z43clang_CompileCommand_getMappedSourceContent",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.clangc/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/libclang/CXCompilationDatabase.cpp -nm=_Z43clang_CompileCommand_getMappedSourceContent")
//</editor-fold>
public /*static*/ default CXString clang_CompileCommand_getMappedSourceContent(CXCompileCommand CCmd, /*uint*/int I) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class CXCompilationDatabaseGlobals
