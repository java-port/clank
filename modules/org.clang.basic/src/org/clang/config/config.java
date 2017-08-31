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
package org.clang.config;

import org.clank.support.Converted;
import org.clank.support.NativePointer;
import org.clank.support.aliases.*;
import static org.clank.support.literal_constants.*;

/**
 * 
 * @author Vladimir Voskresensky
 */
//<editor-fold defaultstate="collapsed" desc="CollectArgsForIntegratedAssembler">
@Converted(kind = Converted.Kind.MANUAL_ADDED, source = "${LLVM_SRC}/build/tools/clang/include/clang/Config/config.h")
//</editor-fold>
public final class config {
  private config() { }
  
/* Bug report URL. */
//#define BUG_REPORT_URL "http://llvm.org/bugs/"
  public static final String BUG_REPORT_URL = "http://llvm.org/bugs/";

/* Default C++ stdlib to use. */
//#define CLANG_DEFAULT_CXX_STDLIB ""
  public static final String CLANG_DEFAULT_CXX_STDLIB = "";

/* Default OpenMP runtime used by -fopenmp. */
//#define CLANG_DEFAULT_OPENMP_RUNTIME "libomp"
  public static final String CLANG_DEFAULT_OPENMP_RUNTIME = "libomp";
  
/* Multilib suffix for libdir. */
//#define CLANG_LIBDIR_SUFFIX ""
  public static final String CLANG_LIBDIR_SUFFIX = "";
  
/* Relative directory for resource files */
//#define CLANG_RESOURCE_DIR ""
  public static final String  CLANG_RESOURCE_DIR = "";
  
/* Directories clang will search for headers */
//#define C_INCLUDE_DIRS ""
  public static final String C_INCLUDE_DIRS = "";
  
/* Default <path> to all compiler invocations for --sysroot=<path>. */
//#define DEFAULT_SYSROOT ""
  public static final String DEFAULT_SYSROOT = "";
  
/* Directory where gcc is installed. */
//#define GCC_INSTALL_PREFIX ""
  public static final String GCC_INSTALL_PREFIX = "";
  
/* Define if we have libxml2 */
//#define CLANG_HAVE_LIBXML 1
  public static final boolean CLANG_HAVE_LIBXML = true;
  
/* The LLVM product name and version */
//#define BACKEND_PACKAGE_STRING "LLVM 3.9.0"
  public static final String BACKEND_PACKAGE_STRING = "LLVM 3.9.0";
/* enable x86 relax relocations by default */
//#define ENABLE_X86_RELAX_RELOCATIONS 0
  public static final boolean ENABLE_X86_RELAX_RELOCATIONS = false;
  
// from ${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Version.h 
// generated as ${LLVM_SRC}/build/tools/clang/include/clang/Basic/Version.inc
  public static final String CLANG_VERSION_STRING = "3.9.0";
  public static final char$ptr CLANG_VERSION_MAJOR = $3;
  public static final char$ptr CLANG_VERSION_MINOR = $9;
  public static final char$ptr CLANG_VERSION_PATCHLEVEL = $0;
  
  public static final char$ptr SVN_REPOSITORY = NativePointer.create_char$ptr_utf8("tags/RELEASE_390/final");
  public static final char$ptr SVN_REVISION = NativePointer.create_char$ptr_utf8("280509");
  public static final char$ptr LLVM_REPOSITORY = NativePointer.create_char$ptr_utf8("llvm/tags/RELEASE_390/final");
  public static final char$ptr LLVM_REVISION = NativePointer.create_char$ptr_utf8("280509");
}
