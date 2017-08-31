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

package org.clang.basic;

import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.basic.*;


/// \brief OpenCL supported extensions and optional core features
//<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLOptions.h", line = 24,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 166,
 FQN="clang::OpenCLOptions", NM="_ZN5clang13OpenCLOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang13OpenCLOptionsE")
//</editor-fold>
public class OpenCLOptions {
/*public:*/
  // OPENCLEXT_INTERNAL
  
  // OpenCL 1.0.
  public /*JBIT unsigned int*/ boolean cl_khr_3d_image_writes /*: 1*/;
  // fprounding mode is special since it is not mentioned beyond 1.0
  public /*JBIT unsigned int*/ boolean cl_khr_select_fprounding_mode /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_byte_addressable_store /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_fp16 /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_fp64 /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_global_int32_base_atomics /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_global_int32_extended_atomics /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_local_int32_base_atomics /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_local_int32_extended_atomics /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_int64_base_atomics /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_int64_extended_atomics /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_gl_sharing /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_icd /*: 1*/;
  
  // OpenCL 1.1.
  public /*JBIT unsigned int*/ boolean cl_khr_gl_event /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_d3d10_sharing /*: 1*/;
  
  // OpenCL 1.2.
  public /*JBIT unsigned int*/ boolean cl_khr_context_abort /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_d3d11_sharing /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_depth_images /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_dx9_media_sharing /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_image2d_from_buffer /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_initialize_memory /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_gl_depth_images /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_gl_msaa_sharing /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_spir /*: 1*/;
  
  // OpenCL 2.0.
  public /*JBIT unsigned int*/ boolean cl_khr_egl_event /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_egl_image /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_srgb_image_writes /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_subgroups /*: 1*/;
  public /*JBIT unsigned int*/ boolean cl_khr_terminate_context /*: 1*/;
  
  // Clang Extensions.
  public /*JBIT unsigned int*/ boolean cl_clang_storage_class_specifiers /*: 1*/;
  
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::OpenCLOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLOptions.h", line = 29,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 171,
   FQN="clang::OpenCLOptions::OpenCLOptions", NM="_ZN5clang13OpenCLOptionsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang13OpenCLOptionsC1Ev")
  //</editor-fold>
  public OpenCLOptions() {
    // OPENCLEXT_INTERNAL
    
    // OpenCL 1.0.
    cl_khr_3d_image_writes = false;
    // fprounding mode is special since it is not mentioned beyond 1.0
    cl_khr_select_fprounding_mode = false;
    cl_khr_byte_addressable_store = false;
    cl_khr_fp16 = false;
    cl_khr_fp64 = false;
    cl_khr_global_int32_base_atomics = false;
    cl_khr_global_int32_extended_atomics = false;
    cl_khr_local_int32_base_atomics = false;
    cl_khr_local_int32_extended_atomics = false;
    cl_khr_int64_base_atomics = false;
    cl_khr_int64_extended_atomics = false;
    cl_khr_gl_sharing = false;
    cl_khr_icd = false;
    
    // OpenCL 1.1.
    cl_khr_gl_event = false;
    cl_khr_d3d10_sharing = false;
    
    // OpenCL 1.2.
    cl_khr_context_abort = false;
    cl_khr_d3d11_sharing = false;
    cl_khr_depth_images = false;
    cl_khr_dx9_media_sharing = false;
    cl_khr_image2d_from_buffer = false;
    cl_khr_initialize_memory = false;
    cl_khr_gl_depth_images = false;
    cl_khr_gl_msaa_sharing = false;
    cl_khr_spir = false;
    
    // OpenCL 2.0.
    cl_khr_egl_event = false;
    cl_khr_egl_image = false;
    cl_khr_srgb_image_writes = false;
    cl_khr_subgroups = false;
    cl_khr_terminate_context = false;
    
    // Clang Extensions.
    cl_clang_storage_class_specifiers = false;
  }

  
  // Enable all options.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::setAll">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLOptions.h", line = 35,
   FQN="clang::OpenCLOptions::setAll", NM="_ZN5clang13OpenCLOptions6setAllEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang13OpenCLOptions6setAllEv")
  //</editor-fold>
  public void setAll() {
    // OPENCLEXT_INTERNAL
    
    // OpenCL 1.0.
    cl_khr_3d_image_writes = true;
    // fprounding mode is special since it is not mentioned beyond 1.0
    cl_khr_select_fprounding_mode = true;
    cl_khr_byte_addressable_store = true;
    cl_khr_fp16 = true;
    cl_khr_fp64 = true;
    cl_khr_global_int32_base_atomics = true;
    cl_khr_global_int32_extended_atomics = true;
    cl_khr_local_int32_base_atomics = true;
    cl_khr_local_int32_extended_atomics = true;
    cl_khr_int64_base_atomics = true;
    cl_khr_int64_extended_atomics = true;
    cl_khr_gl_sharing = true;
    cl_khr_icd = true;
    
    // OpenCL 1.1.
    cl_khr_gl_event = true;
    cl_khr_d3d10_sharing = true;
    
    // OpenCL 1.2.
    cl_khr_context_abort = true;
    cl_khr_d3d11_sharing = true;
    cl_khr_depth_images = true;
    cl_khr_dx9_media_sharing = true;
    cl_khr_image2d_from_buffer = true;
    cl_khr_initialize_memory = true;
    cl_khr_gl_depth_images = true;
    cl_khr_gl_msaa_sharing = true;
    cl_khr_spir = true;
    
    // OpenCL 2.0.
    cl_khr_egl_event = true;
    cl_khr_egl_image = true;
    cl_khr_srgb_image_writes = true;
    cl_khr_subgroups = true;
    cl_khr_terminate_context = true;
    
    // Clang Extensions.
    cl_clang_storage_class_specifiers = true;
  }

  // OPENCLEXT_INTERNAL
  
  // OpenCL 1.0.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_3d_image_writes_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 37,
   FQN="clang::OpenCLOptions::is_cl_khr_3d_image_writes_supported", NM="_ZNK5clang13OpenCLOptions35is_cl_khr_3d_image_writes_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions35is_cl_khr_3d_image_writes_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_3d_image_writes_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_3d_image_writes && $greatereq_uint(OCLVer, 100);
  }

  // fprounding mode is special since it is not mentioned beyond 1.0
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_select_fprounding_mode_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 39,
   FQN="clang::OpenCLOptions::is_cl_khr_select_fprounding_mode_supported", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_select_fprounding_mode_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_select_fprounding_mode_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_select_fprounding_mode_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_select_fprounding_mode && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_byte_addressable_store_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 40,
   FQN="clang::OpenCLOptions::is_cl_khr_byte_addressable_store_supported", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_byte_addressable_store_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_byte_addressable_store_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_byte_addressable_store_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_byte_addressable_store && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_fp16_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 41,
   FQN="clang::OpenCLOptions::is_cl_khr_fp16_supported", NM="_ZNK5clang13OpenCLOptions24is_cl_khr_fp16_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions24is_cl_khr_fp16_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_fp16_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_fp16 && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_fp64_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 42,
   FQN="clang::OpenCLOptions::is_cl_khr_fp64_supported", NM="_ZNK5clang13OpenCLOptions24is_cl_khr_fp64_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions24is_cl_khr_fp64_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_fp64_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_fp64 && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_global_int32_base_atomics_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 43,
   FQN="clang::OpenCLOptions::is_cl_khr_global_int32_base_atomics_supported", NM="_ZNK5clang13OpenCLOptions45is_cl_khr_global_int32_base_atomics_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions45is_cl_khr_global_int32_base_atomics_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_global_int32_base_atomics_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_global_int32_base_atomics && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_global_int32_extended_atomics_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 44,
   FQN="clang::OpenCLOptions::is_cl_khr_global_int32_extended_atomics_supported", NM="_ZNK5clang13OpenCLOptions49is_cl_khr_global_int32_extended_atomics_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions49is_cl_khr_global_int32_extended_atomics_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_global_int32_extended_atomics_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_global_int32_extended_atomics && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_local_int32_base_atomics_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 45,
   FQN="clang::OpenCLOptions::is_cl_khr_local_int32_base_atomics_supported", NM="_ZNK5clang13OpenCLOptions44is_cl_khr_local_int32_base_atomics_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions44is_cl_khr_local_int32_base_atomics_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_local_int32_base_atomics_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_local_int32_base_atomics && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_local_int32_extended_atomics_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 46,
   FQN="clang::OpenCLOptions::is_cl_khr_local_int32_extended_atomics_supported", NM="_ZNK5clang13OpenCLOptions48is_cl_khr_local_int32_extended_atomics_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions48is_cl_khr_local_int32_extended_atomics_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_local_int32_extended_atomics_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_local_int32_extended_atomics && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_int64_base_atomics_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 47,
   FQN="clang::OpenCLOptions::is_cl_khr_int64_base_atomics_supported", NM="_ZNK5clang13OpenCLOptions38is_cl_khr_int64_base_atomics_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions38is_cl_khr_int64_base_atomics_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_int64_base_atomics_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_int64_base_atomics && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_int64_extended_atomics_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 48,
   FQN="clang::OpenCLOptions::is_cl_khr_int64_extended_atomics_supported", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_int64_extended_atomics_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_int64_extended_atomics_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_int64_extended_atomics_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_int64_extended_atomics && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_sharing_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 49,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_sharing_supported", NM="_ZNK5clang13OpenCLOptions30is_cl_khr_gl_sharing_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions30is_cl_khr_gl_sharing_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_sharing_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_gl_sharing && $greatereq_uint(OCLVer, 100);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_icd_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 50,
   FQN="clang::OpenCLOptions::is_cl_khr_icd_supported", NM="_ZNK5clang13OpenCLOptions23is_cl_khr_icd_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions23is_cl_khr_icd_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_icd_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_icd && $greatereq_uint(OCLVer, 100);
  }

  
  // OpenCL 1.1.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_event_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 53,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_event_supported", NM="_ZNK5clang13OpenCLOptions28is_cl_khr_gl_event_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions28is_cl_khr_gl_event_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_event_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_gl_event && $greatereq_uint(OCLVer, 110);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_d3d10_sharing_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 54,
   FQN="clang::OpenCLOptions::is_cl_khr_d3d10_sharing_supported", NM="_ZNK5clang13OpenCLOptions33is_cl_khr_d3d10_sharing_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions33is_cl_khr_d3d10_sharing_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_d3d10_sharing_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_d3d10_sharing && $greatereq_uint(OCLVer, 110);
  }

  
  // OpenCL 1.2.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_context_abort_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 57,
   FQN="clang::OpenCLOptions::is_cl_khr_context_abort_supported", NM="_ZNK5clang13OpenCLOptions33is_cl_khr_context_abort_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions33is_cl_khr_context_abort_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_context_abort_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_context_abort && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_d3d11_sharing_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 58,
   FQN="clang::OpenCLOptions::is_cl_khr_d3d11_sharing_supported", NM="_ZNK5clang13OpenCLOptions33is_cl_khr_d3d11_sharing_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions33is_cl_khr_d3d11_sharing_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_d3d11_sharing_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_d3d11_sharing && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_depth_images_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 59,
   FQN="clang::OpenCLOptions::is_cl_khr_depth_images_supported", NM="_ZNK5clang13OpenCLOptions32is_cl_khr_depth_images_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions32is_cl_khr_depth_images_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_depth_images_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_depth_images && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_dx9_media_sharing_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 60,
   FQN="clang::OpenCLOptions::is_cl_khr_dx9_media_sharing_supported", NM="_ZNK5clang13OpenCLOptions37is_cl_khr_dx9_media_sharing_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions37is_cl_khr_dx9_media_sharing_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_dx9_media_sharing_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_dx9_media_sharing && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_image2d_from_buffer_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 61,
   FQN="clang::OpenCLOptions::is_cl_khr_image2d_from_buffer_supported", NM="_ZNK5clang13OpenCLOptions39is_cl_khr_image2d_from_buffer_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions39is_cl_khr_image2d_from_buffer_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_image2d_from_buffer_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_image2d_from_buffer && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_initialize_memory_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 62,
   FQN="clang::OpenCLOptions::is_cl_khr_initialize_memory_supported", NM="_ZNK5clang13OpenCLOptions37is_cl_khr_initialize_memory_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions37is_cl_khr_initialize_memory_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_initialize_memory_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_initialize_memory && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_depth_images_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 63,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_depth_images_supported", NM="_ZNK5clang13OpenCLOptions35is_cl_khr_gl_depth_images_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions35is_cl_khr_gl_depth_images_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_depth_images_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_gl_depth_images && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_msaa_sharing_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 64,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_msaa_sharing_supported", NM="_ZNK5clang13OpenCLOptions35is_cl_khr_gl_msaa_sharing_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions35is_cl_khr_gl_msaa_sharing_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_msaa_sharing_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_gl_msaa_sharing && $greatereq_uint(OCLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_spir_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 65,
   FQN="clang::OpenCLOptions::is_cl_khr_spir_supported", NM="_ZNK5clang13OpenCLOptions24is_cl_khr_spir_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions24is_cl_khr_spir_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_spir_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_spir && $greatereq_uint(OCLVer, 120);
  }

  
  // OpenCL 2.0.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_egl_event_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 68,
   FQN="clang::OpenCLOptions::is_cl_khr_egl_event_supported", NM="_ZNK5clang13OpenCLOptions29is_cl_khr_egl_event_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions29is_cl_khr_egl_event_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_egl_event_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_egl_event && $greatereq_uint(OCLVer, 200);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_egl_image_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 69,
   FQN="clang::OpenCLOptions::is_cl_khr_egl_image_supported", NM="_ZNK5clang13OpenCLOptions29is_cl_khr_egl_image_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions29is_cl_khr_egl_image_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_egl_image_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_egl_image && $greatereq_uint(OCLVer, 200);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_srgb_image_writes_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 70,
   FQN="clang::OpenCLOptions::is_cl_khr_srgb_image_writes_supported", NM="_ZNK5clang13OpenCLOptions37is_cl_khr_srgb_image_writes_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions37is_cl_khr_srgb_image_writes_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_srgb_image_writes_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_srgb_image_writes && $greatereq_uint(OCLVer, 200);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_subgroups_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 71,
   FQN="clang::OpenCLOptions::is_cl_khr_subgroups_supported", NM="_ZNK5clang13OpenCLOptions29is_cl_khr_subgroups_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions29is_cl_khr_subgroups_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_subgroups_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_subgroups && $greatereq_uint(OCLVer, 200);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_terminate_context_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 72,
   FQN="clang::OpenCLOptions::is_cl_khr_terminate_context_supported", NM="_ZNK5clang13OpenCLOptions37is_cl_khr_terminate_context_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions37is_cl_khr_terminate_context_supportedEj")
  //</editor-fold>
  public boolean is_cl_khr_terminate_context_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_khr_terminate_context && $greatereq_uint(OCLVer, 200);
  }

  
  // Clang Extensions.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_clang_storage_class_specifiers_supported">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 75,
   FQN="clang::OpenCLOptions::is_cl_clang_storage_class_specifiers_supported", NM="_ZNK5clang13OpenCLOptions46is_cl_clang_storage_class_specifiers_supportedEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions46is_cl_clang_storage_class_specifiers_supportedEj")
  //</editor-fold>
  public boolean is_cl_clang_storage_class_specifiers_supported(/*uint*/int OCLVer) /*const*/ {
    return cl_clang_storage_class_specifiers && $greatereq_uint(OCLVer, 100);
  }

  // OPENCLEXT_INTERNAL
  
  // OpenCL 1.0.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_3d_image_writes_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 37,
   FQN="clang::OpenCLOptions::is_cl_khr_3d_image_writes_supported_extension", NM="_ZNK5clang13OpenCLOptions45is_cl_khr_3d_image_writes_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions45is_cl_khr_3d_image_writes_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_3d_image_writes_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_3d_image_writes_supported(CLVer) && (200 == ~0/*U*/ || $less_uint(CLVer, 200));
  }

  // fprounding mode is special since it is not mentioned beyond 1.0
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_select_fprounding_mode_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 39,
   FQN="clang::OpenCLOptions::is_cl_khr_select_fprounding_mode_supported_extension", NM="_ZNK5clang13OpenCLOptions52is_cl_khr_select_fprounding_mode_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions52is_cl_khr_select_fprounding_mode_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_select_fprounding_mode_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_select_fprounding_mode_supported(CLVer) && (110 == ~0/*U*/ || $less_uint(CLVer, 110));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_byte_addressable_store_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 40,
   FQN="clang::OpenCLOptions::is_cl_khr_byte_addressable_store_supported_extension", NM="_ZNK5clang13OpenCLOptions52is_cl_khr_byte_addressable_store_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions52is_cl_khr_byte_addressable_store_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_byte_addressable_store_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_byte_addressable_store_supported(CLVer) && (110 == ~0/*U*/ || $less_uint(CLVer, 110));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_fp16_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 41,
   FQN="clang::OpenCLOptions::is_cl_khr_fp16_supported_extension", NM="_ZNK5clang13OpenCLOptions34is_cl_khr_fp16_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions34is_cl_khr_fp16_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_fp16_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_fp16_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_fp64_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 42,
   FQN="clang::OpenCLOptions::is_cl_khr_fp64_supported_extension", NM="_ZNK5clang13OpenCLOptions34is_cl_khr_fp64_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions34is_cl_khr_fp64_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_fp64_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_fp64_supported(CLVer) && (120 == ~0/*U*/ || $less_uint(CLVer, 120));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_global_int32_base_atomics_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 43,
   FQN="clang::OpenCLOptions::is_cl_khr_global_int32_base_atomics_supported_extension", NM="_ZNK5clang13OpenCLOptions55is_cl_khr_global_int32_base_atomics_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions55is_cl_khr_global_int32_base_atomics_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_global_int32_base_atomics_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_global_int32_base_atomics_supported(CLVer) && (110 == ~0/*U*/ || $less_uint(CLVer, 110));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_global_int32_extended_atomics_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 44,
   FQN="clang::OpenCLOptions::is_cl_khr_global_int32_extended_atomics_supported_extension", NM="_ZNK5clang13OpenCLOptions59is_cl_khr_global_int32_extended_atomics_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions59is_cl_khr_global_int32_extended_atomics_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_global_int32_extended_atomics_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_global_int32_extended_atomics_supported(CLVer) && (110 == ~0/*U*/ || $less_uint(CLVer, 110));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_local_int32_base_atomics_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 45,
   FQN="clang::OpenCLOptions::is_cl_khr_local_int32_base_atomics_supported_extension", NM="_ZNK5clang13OpenCLOptions54is_cl_khr_local_int32_base_atomics_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions54is_cl_khr_local_int32_base_atomics_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_local_int32_base_atomics_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_local_int32_base_atomics_supported(CLVer) && (110 == ~0/*U*/ || $less_uint(CLVer, 110));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_local_int32_extended_atomics_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 46,
   FQN="clang::OpenCLOptions::is_cl_khr_local_int32_extended_atomics_supported_extension", NM="_ZNK5clang13OpenCLOptions58is_cl_khr_local_int32_extended_atomics_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions58is_cl_khr_local_int32_extended_atomics_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_local_int32_extended_atomics_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_local_int32_extended_atomics_supported(CLVer) && (110 == ~0/*U*/ || $less_uint(CLVer, 110));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_int64_base_atomics_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 47,
   FQN="clang::OpenCLOptions::is_cl_khr_int64_base_atomics_supported_extension", NM="_ZNK5clang13OpenCLOptions48is_cl_khr_int64_base_atomics_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions48is_cl_khr_int64_base_atomics_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_int64_base_atomics_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_int64_base_atomics_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_int64_extended_atomics_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 48,
   FQN="clang::OpenCLOptions::is_cl_khr_int64_extended_atomics_supported_extension", NM="_ZNK5clang13OpenCLOptions52is_cl_khr_int64_extended_atomics_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions52is_cl_khr_int64_extended_atomics_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_int64_extended_atomics_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_int64_extended_atomics_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_sharing_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 49,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_sharing_supported_extension", NM="_ZNK5clang13OpenCLOptions40is_cl_khr_gl_sharing_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions40is_cl_khr_gl_sharing_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_sharing_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_sharing_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_icd_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 50,
   FQN="clang::OpenCLOptions::is_cl_khr_icd_supported_extension", NM="_ZNK5clang13OpenCLOptions33is_cl_khr_icd_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions33is_cl_khr_icd_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_icd_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_icd_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  
  // OpenCL 1.1.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_event_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 53,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_event_supported_extension", NM="_ZNK5clang13OpenCLOptions38is_cl_khr_gl_event_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions38is_cl_khr_gl_event_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_event_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_event_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_d3d10_sharing_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 54,
   FQN="clang::OpenCLOptions::is_cl_khr_d3d10_sharing_supported_extension", NM="_ZNK5clang13OpenCLOptions43is_cl_khr_d3d10_sharing_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions43is_cl_khr_d3d10_sharing_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_d3d10_sharing_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_d3d10_sharing_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  
  // OpenCL 1.2.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_context_abort_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 57,
   FQN="clang::OpenCLOptions::is_cl_khr_context_abort_supported_extension", NM="_ZNK5clang13OpenCLOptions43is_cl_khr_context_abort_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions43is_cl_khr_context_abort_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_context_abort_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_context_abort_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_d3d11_sharing_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 58,
   FQN="clang::OpenCLOptions::is_cl_khr_d3d11_sharing_supported_extension", NM="_ZNK5clang13OpenCLOptions43is_cl_khr_d3d11_sharing_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions43is_cl_khr_d3d11_sharing_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_d3d11_sharing_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_d3d11_sharing_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_depth_images_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 59,
   FQN="clang::OpenCLOptions::is_cl_khr_depth_images_supported_extension", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_depth_images_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_depth_images_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_depth_images_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_depth_images_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_dx9_media_sharing_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 60,
   FQN="clang::OpenCLOptions::is_cl_khr_dx9_media_sharing_supported_extension", NM="_ZNK5clang13OpenCLOptions47is_cl_khr_dx9_media_sharing_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions47is_cl_khr_dx9_media_sharing_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_dx9_media_sharing_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_dx9_media_sharing_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_image2d_from_buffer_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 61,
   FQN="clang::OpenCLOptions::is_cl_khr_image2d_from_buffer_supported_extension", NM="_ZNK5clang13OpenCLOptions49is_cl_khr_image2d_from_buffer_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions49is_cl_khr_image2d_from_buffer_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_image2d_from_buffer_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_image2d_from_buffer_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_initialize_memory_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 62,
   FQN="clang::OpenCLOptions::is_cl_khr_initialize_memory_supported_extension", NM="_ZNK5clang13OpenCLOptions47is_cl_khr_initialize_memory_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions47is_cl_khr_initialize_memory_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_initialize_memory_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_initialize_memory_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_depth_images_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 63,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_depth_images_supported_extension", NM="_ZNK5clang13OpenCLOptions45is_cl_khr_gl_depth_images_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions45is_cl_khr_gl_depth_images_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_depth_images_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_depth_images_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_msaa_sharing_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 64,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_msaa_sharing_supported_extension", NM="_ZNK5clang13OpenCLOptions45is_cl_khr_gl_msaa_sharing_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions45is_cl_khr_gl_msaa_sharing_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_msaa_sharing_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_msaa_sharing_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_spir_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 65,
   FQN="clang::OpenCLOptions::is_cl_khr_spir_supported_extension", NM="_ZNK5clang13OpenCLOptions34is_cl_khr_spir_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions34is_cl_khr_spir_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_spir_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_spir_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  
  // OpenCL 2.0.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_egl_event_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 68,
   FQN="clang::OpenCLOptions::is_cl_khr_egl_event_supported_extension", NM="_ZNK5clang13OpenCLOptions39is_cl_khr_egl_event_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions39is_cl_khr_egl_event_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_egl_event_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_egl_event_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_egl_image_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 69,
   FQN="clang::OpenCLOptions::is_cl_khr_egl_image_supported_extension", NM="_ZNK5clang13OpenCLOptions39is_cl_khr_egl_image_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions39is_cl_khr_egl_image_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_egl_image_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_egl_image_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_srgb_image_writes_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 70,
   FQN="clang::OpenCLOptions::is_cl_khr_srgb_image_writes_supported_extension", NM="_ZNK5clang13OpenCLOptions47is_cl_khr_srgb_image_writes_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions47is_cl_khr_srgb_image_writes_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_srgb_image_writes_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_srgb_image_writes_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_subgroups_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 71,
   FQN="clang::OpenCLOptions::is_cl_khr_subgroups_supported_extension", NM="_ZNK5clang13OpenCLOptions39is_cl_khr_subgroups_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions39is_cl_khr_subgroups_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_subgroups_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_subgroups_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_terminate_context_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 72,
   FQN="clang::OpenCLOptions::is_cl_khr_terminate_context_supported_extension", NM="_ZNK5clang13OpenCLOptions47is_cl_khr_terminate_context_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions47is_cl_khr_terminate_context_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_khr_terminate_context_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_terminate_context_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  
  // Clang Extensions.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_clang_storage_class_specifiers_supported_extension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 75,
   FQN="clang::OpenCLOptions::is_cl_clang_storage_class_specifiers_supported_extension", NM="_ZNK5clang13OpenCLOptions56is_cl_clang_storage_class_specifiers_supported_extensionEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions56is_cl_clang_storage_class_specifiers_supported_extensionEj")
  //</editor-fold>
  public boolean is_cl_clang_storage_class_specifiers_supported_extension(/*uint*/int CLVer) /*const*/ {
    return is_cl_clang_storage_class_specifiers_supported(CLVer) && (~0/*U*/ == ~0/*U*/ || $less_uint(CLVer, ~0/*U*/));
  }

  // OPENCLEXT_INTERNAL
  
  // OpenCL 1.0.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_3d_image_writes_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 37,
   FQN="clang::OpenCLOptions::is_cl_khr_3d_image_writes_supported_core", NM="_ZNK5clang13OpenCLOptions40is_cl_khr_3d_image_writes_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions40is_cl_khr_3d_image_writes_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_3d_image_writes_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_3d_image_writes_supported(CLVer) && 200 != ~0/*U*/ && $greatereq_uint(CLVer, 200);
  }

  // fprounding mode is special since it is not mentioned beyond 1.0
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_select_fprounding_mode_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 39,
   FQN="clang::OpenCLOptions::is_cl_khr_select_fprounding_mode_supported_core", NM="_ZNK5clang13OpenCLOptions47is_cl_khr_select_fprounding_mode_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions47is_cl_khr_select_fprounding_mode_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_select_fprounding_mode_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_select_fprounding_mode_supported(CLVer) && 110 != ~0/*U*/ && $greatereq_uint(CLVer, 110);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_byte_addressable_store_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 40,
   FQN="clang::OpenCLOptions::is_cl_khr_byte_addressable_store_supported_core", NM="_ZNK5clang13OpenCLOptions47is_cl_khr_byte_addressable_store_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions47is_cl_khr_byte_addressable_store_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_byte_addressable_store_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_byte_addressable_store_supported(CLVer) && 110 != ~0/*U*/ && $greatereq_uint(CLVer, 110);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_fp16_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 41,
   FQN="clang::OpenCLOptions::is_cl_khr_fp16_supported_core", NM="_ZNK5clang13OpenCLOptions29is_cl_khr_fp16_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions29is_cl_khr_fp16_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_fp16_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_fp16_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_fp64_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 42,
   FQN="clang::OpenCLOptions::is_cl_khr_fp64_supported_core", NM="_ZNK5clang13OpenCLOptions29is_cl_khr_fp64_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions29is_cl_khr_fp64_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_fp64_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_fp64_supported(CLVer) && 120 != ~0/*U*/ && $greatereq_uint(CLVer, 120);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_global_int32_base_atomics_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 43,
   FQN="clang::OpenCLOptions::is_cl_khr_global_int32_base_atomics_supported_core", NM="_ZNK5clang13OpenCLOptions50is_cl_khr_global_int32_base_atomics_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions50is_cl_khr_global_int32_base_atomics_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_global_int32_base_atomics_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_global_int32_base_atomics_supported(CLVer) && 110 != ~0/*U*/ && $greatereq_uint(CLVer, 110);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_global_int32_extended_atomics_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 44,
   FQN="clang::OpenCLOptions::is_cl_khr_global_int32_extended_atomics_supported_core", NM="_ZNK5clang13OpenCLOptions54is_cl_khr_global_int32_extended_atomics_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions54is_cl_khr_global_int32_extended_atomics_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_global_int32_extended_atomics_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_global_int32_extended_atomics_supported(CLVer) && 110 != ~0/*U*/ && $greatereq_uint(CLVer, 110);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_local_int32_base_atomics_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 45,
   FQN="clang::OpenCLOptions::is_cl_khr_local_int32_base_atomics_supported_core", NM="_ZNK5clang13OpenCLOptions49is_cl_khr_local_int32_base_atomics_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions49is_cl_khr_local_int32_base_atomics_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_local_int32_base_atomics_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_local_int32_base_atomics_supported(CLVer) && 110 != ~0/*U*/ && $greatereq_uint(CLVer, 110);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_local_int32_extended_atomics_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 46,
   FQN="clang::OpenCLOptions::is_cl_khr_local_int32_extended_atomics_supported_core", NM="_ZNK5clang13OpenCLOptions53is_cl_khr_local_int32_extended_atomics_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions53is_cl_khr_local_int32_extended_atomics_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_local_int32_extended_atomics_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_local_int32_extended_atomics_supported(CLVer) && 110 != ~0/*U*/ && $greatereq_uint(CLVer, 110);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_int64_base_atomics_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 47,
   FQN="clang::OpenCLOptions::is_cl_khr_int64_base_atomics_supported_core", NM="_ZNK5clang13OpenCLOptions43is_cl_khr_int64_base_atomics_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions43is_cl_khr_int64_base_atomics_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_int64_base_atomics_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_int64_base_atomics_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_int64_extended_atomics_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 48,
   FQN="clang::OpenCLOptions::is_cl_khr_int64_extended_atomics_supported_core", NM="_ZNK5clang13OpenCLOptions47is_cl_khr_int64_extended_atomics_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions47is_cl_khr_int64_extended_atomics_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_int64_extended_atomics_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_int64_extended_atomics_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_sharing_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 49,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_sharing_supported_core", NM="_ZNK5clang13OpenCLOptions35is_cl_khr_gl_sharing_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions35is_cl_khr_gl_sharing_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_sharing_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_sharing_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_icd_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 50,
   FQN="clang::OpenCLOptions::is_cl_khr_icd_supported_core", NM="_ZNK5clang13OpenCLOptions28is_cl_khr_icd_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions28is_cl_khr_icd_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_icd_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_icd_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  
  // OpenCL 1.1.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_event_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 53,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_event_supported_core", NM="_ZNK5clang13OpenCLOptions33is_cl_khr_gl_event_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions33is_cl_khr_gl_event_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_event_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_event_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_d3d10_sharing_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 54,
   FQN="clang::OpenCLOptions::is_cl_khr_d3d10_sharing_supported_core", NM="_ZNK5clang13OpenCLOptions38is_cl_khr_d3d10_sharing_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions38is_cl_khr_d3d10_sharing_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_d3d10_sharing_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_d3d10_sharing_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  
  // OpenCL 1.2.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_context_abort_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 57,
   FQN="clang::OpenCLOptions::is_cl_khr_context_abort_supported_core", NM="_ZNK5clang13OpenCLOptions38is_cl_khr_context_abort_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions38is_cl_khr_context_abort_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_context_abort_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_context_abort_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_d3d11_sharing_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 58,
   FQN="clang::OpenCLOptions::is_cl_khr_d3d11_sharing_supported_core", NM="_ZNK5clang13OpenCLOptions38is_cl_khr_d3d11_sharing_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions38is_cl_khr_d3d11_sharing_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_d3d11_sharing_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_d3d11_sharing_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_depth_images_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 59,
   FQN="clang::OpenCLOptions::is_cl_khr_depth_images_supported_core", NM="_ZNK5clang13OpenCLOptions37is_cl_khr_depth_images_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions37is_cl_khr_depth_images_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_depth_images_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_depth_images_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_dx9_media_sharing_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 60,
   FQN="clang::OpenCLOptions::is_cl_khr_dx9_media_sharing_supported_core", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_dx9_media_sharing_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_dx9_media_sharing_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_dx9_media_sharing_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_dx9_media_sharing_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_image2d_from_buffer_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 61,
   FQN="clang::OpenCLOptions::is_cl_khr_image2d_from_buffer_supported_core", NM="_ZNK5clang13OpenCLOptions44is_cl_khr_image2d_from_buffer_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions44is_cl_khr_image2d_from_buffer_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_image2d_from_buffer_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_image2d_from_buffer_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_initialize_memory_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 62,
   FQN="clang::OpenCLOptions::is_cl_khr_initialize_memory_supported_core", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_initialize_memory_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_initialize_memory_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_initialize_memory_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_initialize_memory_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_depth_images_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 63,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_depth_images_supported_core", NM="_ZNK5clang13OpenCLOptions40is_cl_khr_gl_depth_images_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions40is_cl_khr_gl_depth_images_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_depth_images_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_depth_images_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_gl_msaa_sharing_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 64,
   FQN="clang::OpenCLOptions::is_cl_khr_gl_msaa_sharing_supported_core", NM="_ZNK5clang13OpenCLOptions40is_cl_khr_gl_msaa_sharing_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions40is_cl_khr_gl_msaa_sharing_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_gl_msaa_sharing_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_gl_msaa_sharing_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_spir_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 65,
   FQN="clang::OpenCLOptions::is_cl_khr_spir_supported_core", NM="_ZNK5clang13OpenCLOptions29is_cl_khr_spir_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions29is_cl_khr_spir_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_spir_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_spir_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  
  // OpenCL 2.0.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_egl_event_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 68,
   FQN="clang::OpenCLOptions::is_cl_khr_egl_event_supported_core", NM="_ZNK5clang13OpenCLOptions34is_cl_khr_egl_event_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions34is_cl_khr_egl_event_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_egl_event_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_egl_event_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_egl_image_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 69,
   FQN="clang::OpenCLOptions::is_cl_khr_egl_image_supported_core", NM="_ZNK5clang13OpenCLOptions34is_cl_khr_egl_image_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions34is_cl_khr_egl_image_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_egl_image_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_egl_image_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_srgb_image_writes_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 70,
   FQN="clang::OpenCLOptions::is_cl_khr_srgb_image_writes_supported_core", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_srgb_image_writes_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_srgb_image_writes_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_srgb_image_writes_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_srgb_image_writes_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_subgroups_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 71,
   FQN="clang::OpenCLOptions::is_cl_khr_subgroups_supported_core", NM="_ZNK5clang13OpenCLOptions34is_cl_khr_subgroups_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions34is_cl_khr_subgroups_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_subgroups_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_subgroups_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_khr_terminate_context_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 72,
   FQN="clang::OpenCLOptions::is_cl_khr_terminate_context_supported_core", NM="_ZNK5clang13OpenCLOptions42is_cl_khr_terminate_context_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions42is_cl_khr_terminate_context_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_khr_terminate_context_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_khr_terminate_context_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  
  // Clang Extensions.
  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::is_cl_clang_storage_class_specifiers_supported_core">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLExtensions.def", line = 75,
   FQN="clang::OpenCLOptions::is_cl_clang_storage_class_specifiers_supported_core", NM="_ZNK5clang13OpenCLOptions51is_cl_clang_storage_class_specifiers_supported_coreEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK5clang13OpenCLOptions51is_cl_clang_storage_class_specifiers_supported_coreEj")
  //</editor-fold>
  public boolean is_cl_clang_storage_class_specifiers_supported_core(/*uint*/int CLVer) /*const*/ {
    return is_cl_clang_storage_class_specifiers_supported(CLVer) && ~0/*U*/ != ~0/*U*/ && $greatereq_uint(CLVer, ~0/*U*/);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::OpenCLOptions::OpenCLOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/OpenCLOptions.h", line = 24,
   old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/LangOptions.h", old_line = 166,
   FQN="clang::OpenCLOptions::OpenCLOptions", NM="_ZN5clang13OpenCLOptionsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN5clang13OpenCLOptionsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ OpenCLOptions(/*const*/ OpenCLOptions /*&*/ $Prm0) {
    /* : cl_khr_3d_image_writes(.cl_khr_3d_image_writes), cl_khr_select_fprounding_mode(.cl_khr_select_fprounding_mode), cl_khr_byte_addressable_store(.cl_khr_byte_addressable_store), cl_khr_fp16(.cl_khr_fp16), cl_khr_fp64(.cl_khr_fp64), cl_khr_global_int32_base_atomics(.cl_khr_global_int32_base_atomics), cl_khr_global_int32_extended_atomics(.cl_khr_global_int32_extended_atomics), cl_khr_local_int32_base_atomics(.cl_khr_local_int32_base_atomics), cl_khr_local_int32_extended_atomics(.cl_khr_local_int32_extended_atomics), cl_khr_int64_base_atomics(.cl_khr_int64_base_atomics), cl_khr_int64_extended_atomics(.cl_khr_int64_extended_atomics), cl_khr_gl_sharing(.cl_khr_gl_sharing), cl_khr_icd(.cl_khr_icd), cl_khr_gl_event(.cl_khr_gl_event), cl_khr_d3d10_sharing(.cl_khr_d3d10_sharing), cl_khr_context_abort(.cl_khr_context_abort), cl_khr_d3d11_sharing(.cl_khr_d3d11_sharing), cl_khr_depth_images(.cl_khr_depth_images), cl_khr_dx9_media_sharing(.cl_khr_dx9_media_sharing), cl_khr_image2d_from_buffer(.cl_khr_image2d_from_buffer), cl_khr_initialize_memory(.cl_khr_initialize_memory), cl_khr_gl_depth_images(.cl_khr_gl_depth_images), cl_khr_gl_msaa_sharing(.cl_khr_gl_msaa_sharing), cl_khr_spir(.cl_khr_spir), cl_khr_egl_event(.cl_khr_egl_event), cl_khr_egl_image(.cl_khr_egl_image), cl_khr_srgb_image_writes(.cl_khr_srgb_image_writes), cl_khr_subgroups(.cl_khr_subgroups), cl_khr_terminate_context(.cl_khr_terminate_context), cl_clang_storage_class_specifiers(.cl_clang_storage_class_specifiers)*/ 
    //START JInit
    this.cl_khr_3d_image_writes = $Prm0.cl_khr_3d_image_writes;
    this.cl_khr_select_fprounding_mode = $Prm0.cl_khr_select_fprounding_mode;
    this.cl_khr_byte_addressable_store = $Prm0.cl_khr_byte_addressable_store;
    this.cl_khr_fp16 = $Prm0.cl_khr_fp16;
    this.cl_khr_fp64 = $Prm0.cl_khr_fp64;
    this.cl_khr_global_int32_base_atomics = $Prm0.cl_khr_global_int32_base_atomics;
    this.cl_khr_global_int32_extended_atomics = $Prm0.cl_khr_global_int32_extended_atomics;
    this.cl_khr_local_int32_base_atomics = $Prm0.cl_khr_local_int32_base_atomics;
    this.cl_khr_local_int32_extended_atomics = $Prm0.cl_khr_local_int32_extended_atomics;
    this.cl_khr_int64_base_atomics = $Prm0.cl_khr_int64_base_atomics;
    this.cl_khr_int64_extended_atomics = $Prm0.cl_khr_int64_extended_atomics;
    this.cl_khr_gl_sharing = $Prm0.cl_khr_gl_sharing;
    this.cl_khr_icd = $Prm0.cl_khr_icd;
    this.cl_khr_gl_event = $Prm0.cl_khr_gl_event;
    this.cl_khr_d3d10_sharing = $Prm0.cl_khr_d3d10_sharing;
    this.cl_khr_context_abort = $Prm0.cl_khr_context_abort;
    this.cl_khr_d3d11_sharing = $Prm0.cl_khr_d3d11_sharing;
    this.cl_khr_depth_images = $Prm0.cl_khr_depth_images;
    this.cl_khr_dx9_media_sharing = $Prm0.cl_khr_dx9_media_sharing;
    this.cl_khr_image2d_from_buffer = $Prm0.cl_khr_image2d_from_buffer;
    this.cl_khr_initialize_memory = $Prm0.cl_khr_initialize_memory;
    this.cl_khr_gl_depth_images = $Prm0.cl_khr_gl_depth_images;
    this.cl_khr_gl_msaa_sharing = $Prm0.cl_khr_gl_msaa_sharing;
    this.cl_khr_spir = $Prm0.cl_khr_spir;
    this.cl_khr_egl_event = $Prm0.cl_khr_egl_event;
    this.cl_khr_egl_image = $Prm0.cl_khr_egl_image;
    this.cl_khr_srgb_image_writes = $Prm0.cl_khr_srgb_image_writes;
    this.cl_khr_subgroups = $Prm0.cl_khr_subgroups;
    this.cl_khr_terminate_context = $Prm0.cl_khr_terminate_context;
    this.cl_clang_storage_class_specifiers = $Prm0.cl_clang_storage_class_specifiers;
    //END JInit
  }

  
  public String toString() {
    return "" + "cl_khr_3d_image_writes=" + cl_khr_3d_image_writes // NOI18N
              + ", cl_khr_select_fprounding_mode=" + cl_khr_select_fprounding_mode // NOI18N
              + ", cl_khr_byte_addressable_store=" + cl_khr_byte_addressable_store // NOI18N
              + ", cl_khr_fp16=" + cl_khr_fp16 // NOI18N
              + ", cl_khr_fp64=" + cl_khr_fp64 // NOI18N
              + ", cl_khr_global_int32_base_atomics=" + cl_khr_global_int32_base_atomics // NOI18N
              + ", cl_khr_global_int32_extended_atomics=" + cl_khr_global_int32_extended_atomics // NOI18N
              + ", cl_khr_local_int32_base_atomics=" + cl_khr_local_int32_base_atomics // NOI18N
              + ", cl_khr_local_int32_extended_atomics=" + cl_khr_local_int32_extended_atomics // NOI18N
              + ", cl_khr_int64_base_atomics=" + cl_khr_int64_base_atomics // NOI18N
              + ", cl_khr_int64_extended_atomics=" + cl_khr_int64_extended_atomics // NOI18N
              + ", cl_khr_gl_sharing=" + cl_khr_gl_sharing // NOI18N
              + ", cl_khr_icd=" + cl_khr_icd // NOI18N
              + ", cl_khr_gl_event=" + cl_khr_gl_event // NOI18N
              + ", cl_khr_d3d10_sharing=" + cl_khr_d3d10_sharing // NOI18N
              + ", cl_khr_context_abort=" + cl_khr_context_abort // NOI18N
              + ", cl_khr_d3d11_sharing=" + cl_khr_d3d11_sharing // NOI18N
              + ", cl_khr_depth_images=" + cl_khr_depth_images // NOI18N
              + ", cl_khr_dx9_media_sharing=" + cl_khr_dx9_media_sharing // NOI18N
              + ", cl_khr_image2d_from_buffer=" + cl_khr_image2d_from_buffer // NOI18N
              + ", cl_khr_initialize_memory=" + cl_khr_initialize_memory // NOI18N
              + ", cl_khr_gl_depth_images=" + cl_khr_gl_depth_images // NOI18N
              + ", cl_khr_gl_msaa_sharing=" + cl_khr_gl_msaa_sharing // NOI18N
              + ", cl_khr_spir=" + cl_khr_spir // NOI18N
              + ", cl_khr_egl_event=" + cl_khr_egl_event // NOI18N
              + ", cl_khr_egl_image=" + cl_khr_egl_image // NOI18N
              + ", cl_khr_srgb_image_writes=" + cl_khr_srgb_image_writes // NOI18N
              + ", cl_khr_subgroups=" + cl_khr_subgroups // NOI18N
              + ", cl_khr_terminate_context=" + cl_khr_terminate_context // NOI18N
              + ", cl_clang_storage_class_specifiers=" + cl_clang_storage_class_specifiers; // NOI18N
  }
}
